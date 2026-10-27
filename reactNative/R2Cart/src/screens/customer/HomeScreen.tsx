import React, { useState, useEffect, useCallback, useMemo } from 'react';
import {
  View,
  Text,
  StyleSheet,
  TouchableOpacity,
  Image,
  FlatList,
  RefreshControl,
  StatusBar,
  Modal,
  Dimensions,
  ScrollView,
} from 'react-native';
import { AnimatedSection, AnimatedGridItem } from '../../components/common/AnimatedSection';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import Feather from 'react-native-vector-icons/Feather';
import { Colors } from '../../theme/colors';
import { useCart } from '../../context/CartContext';
import { useAuth } from '../../context/AuthContext';
import { useLanguage } from '../../context/LanguageContext';
import { api } from '../../services/api';
import { Product, Category, Banner, Address } from '../../types';
import {
  BannerSkeleton,
  CategoryGridSkeleton,
  ProductCardSkeleton,
} from '../../components/common/Skeleton';
import {
  HeroCarousel,
  ProductCard,
  PRODUCT_ITEM_WIDTH,
  ProductRail,
  CampaignRail,
  CategoryGrid,
  PromoStrip,
  PromiseStrip,
  FloatingCartBar,
} from '../../components/customer';

const { width } = Dimensions.get('window');

export const HomeScreen = ({ navigation }: any) => {
  const insets = useSafeAreaInsets();
  const { user } = useAuth();
  const { lang, toggleLang, t, tCat, tEta } = useLanguage();
  const { addToCart, removeFromCart, getItemQuantity, totalItems, grandTotal } = useCart();

  const [categories, setCategories] = useState<Category[]>([]);
  const [products, setProducts] = useState<Product[]>([]);
  const [banners, setBanners] = useState<Banner[]>([]);
  const [bestSellers, setBestSellers] = useState<Product[]>([]);
  const [topPicks, setTopPicks] = useState<Product[]>([]);
  const [savedAddresses, setSavedAddresses] = useState<Address[]>([]);
  const [availableVillages, setAvailableVillages] = useState<string[]>([]);
  const [selectedLocation, setSelectedLocation] = useState<string>('Hathua');
  const [locationModalVisible, setLocationModalVisible] = useState<boolean>(false);
  const [loading, setLoading] = useState<boolean>(true);
  const [refreshing, setRefreshing] = useState<boolean>(false);

  const fetchData = async () => {
    try {
      const [catRes, prodRes, bannerRes, bestRes, picksRes, deliveryRes, addrRes] = await Promise.allSettled([
        api.getCategories(),
        api.getProducts({ limit: 150 }),
        api.getBanners(),
        api.getBestSellers(),
        api.getTopPicks(),
        api.getDelivery(),
        user ? api.getAddresses() : Promise.resolve({ data: [] }),
      ]);

      let prodList: Product[] = [];
      if (prodRes.status === 'fulfilled' && prodRes.value?.data) {
        prodList = Array.isArray(prodRes.value.data) ? prodRes.value.data.filter(p => p && p.id) : [];
        setProducts(prodList);
      }

      if (catRes.status === 'fulfilled' && catRes.value?.data) {
        const catList = Array.isArray(catRes.value.data) ? catRes.value.data.filter(c => c && c.id) : [];
        setCategories(catList);
      }

      if (bannerRes.status === 'fulfilled' && bannerRes.value?.data) {
        const bList = Array.isArray(bannerRes.value.data) ? bannerRes.value.data.filter(b => b && b.id) : [];
        setBanners(bList);
      }

      // Best Sellers
      let bestList: Product[] = [];
      if (bestRes.status === 'fulfilled' && bestRes.value?.data) {
        const raw = bestRes.value.data as any;
        bestList = Array.isArray(raw) ? raw : (Array.isArray(raw.products) ? raw.products : []);
      }
      if (bestList.length === 0 && prodList.length > 0) {
        bestList = prodList.filter(p => p && (p.bestSeller || p.featured)).slice(0, 10);
      }
      setBestSellers(bestList.filter(p => p && p.id));

      // Top Picks
      let picksList: Product[] = [];
      if (picksRes.status === 'fulfilled' && picksRes.value?.data) {
        const rawPicks = picksRes.value.data as any;
        picksList = Array.isArray(rawPicks) ? rawPicks : (Array.isArray(rawPicks.products) ? rawPicks.products : []);
      }
      if (picksList.length === 0 && prodList.length > 0) {
        picksList = prodList.slice(0, 10);
      }
      setTopPicks(picksList.filter(p => p && p.id));

      // Dynamic delivery areas and villages from backend (Zero hardcoding)
      let dynamicVillages: string[] = [];
      if (deliveryRes.status === 'fulfilled' && deliveryRes.value?.data) {
        const raw = deliveryRes.value.data as any;
        const villagesList = Array.isArray(raw.villages) ? raw.villages : (Array.isArray(raw) ? raw : []);
        dynamicVillages = villagesList.map((v: any) => v.name || v.title).filter(Boolean);
        const areasList = Array.isArray(raw.areas) ? raw.areas : [];
        for (const a of areasList) {
          if (Array.isArray(a.pincodes)) {
            dynamicVillages.push(...a.pincodes);
          }
        }
        dynamicVillages = [...new Set(dynamicVillages)];
        setAvailableVillages(dynamicVillages);
      }

      // Dynamic saved addresses from backend
      let userAddrs: Address[] = [];
      if (addrRes.status === 'fulfilled' && addrRes.value?.data) {
        userAddrs = Array.isArray(addrRes.value.data) ? addrRes.value.data : [];
        setSavedAddresses(userAddrs);
      }

      // Automatically determine selected location matching the website
      if (userAddrs.length > 0) {
        const defaultAddr = userAddrs.find((a: any) => a.isDefault) || userAddrs[0];
        const label = `${defaultAddr.type || 'Home'} - ${defaultAddr.street || defaultAddr.landmark || defaultAddr.area || 'Hathua'}`;
        setSelectedLocation(label);
      } else if (dynamicVillages.length > 0) {
        setSelectedLocation(dynamicVillages[0]);
      } else {
        setSelectedLocation('Hathua');
      }
    } catch {
      // Graceful error fallback
    } finally {
      setLoading(false);
      setRefreshing(false);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  // Sync user saved addresses when user logs in
  useEffect(() => {
    if (user) {
      api.getAddresses().then(res => {
        if (res.data && Array.isArray(res.data) && res.data.length > 0) {
          setSavedAddresses(res.data);
          const defaultAddr = res.data.find((a: any) => a.isDefault) || res.data[0];
          setSelectedLocation(`${defaultAddr.type || 'Home'} - ${defaultAddr.street || defaultAddr.landmark || defaultAddr.area || 'Hathua'}`);
        }
      }).catch(() => {});
    }
  }, [user]);

  const onRefresh = useCallback(() => {
    setRefreshing(true);
    fetchData();
  }, []);

  // Stable callbacks so child components don't re-render unnecessarily
  const handleProductPress = useCallback((productId: string) => {
    navigation.navigate('ProductDetail', { productId });
  }, [navigation]);

  const handleCategoryPress = useCallback((category: Category) => {
    navigation.navigate('Categories', {
      categoryId: category.id,
      categorySlug: category.slug,
      categoryName: category.name,
    });
  }, [navigation]);

  const handleBannerPress = useCallback((banner: Banner) => {
    if (banner.destination?.includes('category/')) {
      const slug = banner.destination.split('category/')[1];
      navigation.navigate('Categories', { categorySlug: slug });
    } else if (banner.destination?.includes('coupons')) {
      navigation.navigate('Coupons');
    } else {
      navigation.navigate('SearchTab');
    }
  }, [navigation]);

  // Derived banner sets matching website: exactly top 2 hero banners
  const heroBanners = useMemo(() => {
    return banners.slice(0, 2);
  }, [banners]);

  const campaignBanners = useMemo(() => {
    return banners.length > 2 ? banners.slice(2) : banners;
  }, [banners]);

  // Derived product rails matching website
  const recommendedProducts = useMemo(() => {
    return products.slice(0, 10);
  }, [products]);

  const specialOffers = useMemo(() => {
    return products
      .filter(p => {
        const price = Number(p.price || 0);
        const mrp = Number(p.mrp || price);
        return mrp > price && Math.round(((mrp - price) / mrp) * 100) >= 15;
      })
      .slice(0, 10);
  }, [products]);

  // Category product rails for ALL categories matching the website
  const allCategoryRails = useMemo(() => {
    if (categories.length === 0 || products.length === 0) return [];
    const rails: { category: Category; items: Product[] }[] = [];

    for (const cat of categories) {
      const catItems = products.filter(
        p =>
          (p as any).categoryId === cat.id ||
          (p as any).category?.id === cat.id ||
          (p as any).categorySlug === cat.slug ||
          (p as any).category?.slug === cat.slug ||
          (typeof p.category === 'string' && (p.category === cat.slug || p.category === cat.name || p.category === cat.id))
      );
      if (catItems.length > 0) {
        rails.push({ category: cat, items: catItems });
      }
    }
    return rails;
  }, [categories, products]);

  // Storefront main grid item renderer — wrapped in AnimatedGridItem for zoom-in on scroll
  const renderProductItem = useCallback(
    ({ item, index }: { item: Product; index: number }) => (
      <AnimatedGridItem index={index}>
        <ProductCard
          product={item}
          quantity={getItemQuantity(item.id)}
          onAdd={addToCart}
          onRemove={removeFromCart}
          onPress={handleProductPress}
          width={PRODUCT_ITEM_WIDTH}
        />
      </AnimatedGridItem>
    ),
    [getItemQuantity, addToCart, removeFromCart, handleProductPress]
  );

  // Header assembling all sections in sequence
  const renderListHeader = useCallback(() => (
    <View>
      {/* #1. Top Hero Banners Carousel — no delay, first thing user sees */}
      <AnimatedSection delay={0} initialScale={0.92}>
        <HeroCarousel banners={heroBanners} onBannerPress={handleBannerPress} />
      </AnimatedSection>

      {/* #2. Offers Picked for You (Campaign Rail) */}
      {campaignBanners.length > 0 && (
        <AnimatedSection delay={80}>
          <CampaignRail
            title="Offers picked for you"
            subtitle="Fresh deals, updated from R2Cart"
            banners={campaignBanners}
            onBannerPress={handleBannerPress}
          />
        </AnimatedSection>
      )}

      {/* #3. Shop by Category (4-Column Responsive Grid) */}
      <AnimatedSection delay={160}>
        <CategoryGrid
          title="Shop by category"
          subtitle="Everything your home needs"
          categories={categories}
          onCategoryPress={handleCategoryPress}
        />
      </AnimatedSection>

      {/* #4. Recommended for You Rail */}
      {recommendedProducts.length > 0 && (
        <AnimatedSection delay={240}>
          <ProductRail
            title="Recommended for you"
            subtitle="Tailored to what you love"
            icon="sparkles"
            iconColor="#10B981"
            products={recommendedProducts}
            onProductPress={handleProductPress}
            onAddToCart={addToCart}
            onRemoveFromCart={removeFromCart}
            getItemQuantity={getItemQuantity}
            onSeeAll={() => navigation.navigate('SearchTab')}
          />
        </AnimatedSection>
      )}

      {/* #5. Best Sellers Rail */}
      {bestSellers.length > 0 && (
        <AnimatedSection delay={320}>
          <ProductRail
            title="Best sellers"
            subtitle="Top selling essentials in your area"
            badge="POPULAR"
            icon="award"
            iconColor="#F59E0B"
            products={bestSellers}
            onProductPress={handleProductPress}
            onAddToCart={addToCart}
            onRemoveFromCart={removeFromCart}
            getItemQuantity={getItemQuantity}
            onSeeAll={() => navigation.navigate('SearchTab', { filter: 'bestseller' })}
          />
        </AnimatedSection>
      )}

      {/* #6. Top Picks Rail */}
      {topPicks.length > 0 && (
        <AnimatedSection delay={400}>
          <ProductRail
            title="Top picks"
            subtitle="Handpicked fresh items"
            badge="10-MIN"
            icon="zap"
            iconColor="#059669"
            products={topPicks}
            onProductPress={handleProductPress}
            onAddToCart={addToCart}
            onRemoveFromCart={removeFromCart}
            getItemQuantity={getItemQuantity}
            onSeeAll={() => navigation.navigate('SearchTab', { filter: 'toppicks' })}
          />
        </AnimatedSection>
      )}

      {/* #7. Savings Promo Strip */}
      <AnimatedSection delay={480}>
        <PromoStrip
          tag="YOUR SAVINGS"
          title="Stock up. Save more."
          subtitle="Explore the current coupons and exclusive discounts for your basket."
          buttonText="Explore offers"
          onPress={() => navigation.navigate('Coupons')}
        />
      </AnimatedSection>

      {/* #8. Category Product Rails for ALL categories (Dairy, Atta, Fruits, etc. dynamically) */}
      {allCategoryRails.map(({ category, items }, catIdx) => (
        <AnimatedSection key={`cat_rail_${category.id || category.slug}`} delay={560 + catIdx * 80}>
          <ProductRail
            title={category.name}
            subtitle={`Fresh ${category.name.toLowerCase()} delivered in 15 mins`}
            products={items}
            onProductPress={handleProductPress}
            onAddToCart={addToCart}
            onRemoveFromCart={removeFromCart}
            getItemQuantity={getItemQuantity}
            onSeeAll={() => handleCategoryPress(category)}
          />
        </AnimatedSection>
      ))}

      {/* #9. Special Offers Rail (High Discounts) */}
      {specialOffers.length > 0 && (
        <AnimatedSection delay={640}>
          <ProductRail
            title="Special offers"
            subtitle="Save big with minimum 15% discount"
            badge="DEALS"
            icon="tag"
            iconColor="#DC2626"
            products={specialOffers}
            onProductPress={handleProductPress}
            onAddToCart={addToCart}
            onRemoveFromCart={removeFromCart}
            getItemQuantity={getItemQuantity}
            onSeeAll={() => navigation.navigate('SearchTab', { filter: 'discount' })}
          />
        </AnimatedSection>
      )}

      {/* #10. Quality & Delivery Promise */}
      <AnimatedSection delay={720}>
        <PromiseStrip />
      </AnimatedSection>

      {/* Storefront Section Header */}
      <AnimatedSection delay={800}>
        <View style={styles.storefrontHeader}>
          <View>
            <Text style={styles.storefrontTitle}>{lang === 'hi' ? 'सभी ताज़ा उत्पाद' : 'All Fresh Products'}</Text>
            <Text style={styles.storefrontSub}>
              {lang === 'hi' ? `${products.length} ताज़ा किराना उत्पाद उपलब्ध हैं` : `${products.length} fresh grocery items available`}
            </Text>
          </View>
        </View>
      </AnimatedSection>
    </View>
  ), [
    lang,
    heroBanners,
    campaignBanners,
    categories,
    recommendedProducts,
    bestSellers,
    topPicks,
    allCategoryRails,
    specialOffers,
    products.length,
    handleBannerPress,
    handleCategoryPress,
    handleProductPress,
    addToCart,
    removeFromCart,
    getItemQuantity,
    navigation,
  ]);

  return (
    <View style={styles.container}>
      <StatusBar barStyle="dark-content" />

      {/* Top Header matching website */}
      <View style={[styles.headerWrap, { paddingTop: insets.top + 6 }]}>
        {/* Row 1: Logo on Left | User/Sign In & Cart on Right */}
        <View style={styles.topRow}>
          <TouchableOpacity activeOpacity={0.9} onPress={onRefresh}>
            <Image
              source={require('../../assets/images/logo.png')}
              style={styles.logoImg}
              resizeMode="contain"
            />
          </TouchableOpacity>

          <View style={styles.topRightActions}>
            {/* Website matching Hindi/English Toggle Pill Button */}
            <TouchableOpacity
              style={styles.langToggleBtn}
              activeOpacity={0.8}
              onPress={toggleLang}
            >
              <Feather name="globe" size={12} color="#059669" />
              <Text style={styles.langToggleText}>
                {lang === 'hi' ? 'EN' : 'हिन्दी'}
              </Text>
            </TouchableOpacity>

            {user ? (
              <TouchableOpacity
                style={styles.userHeaderBtn}
                activeOpacity={0.8}
                onPress={() => navigation.navigate('AccountTab')}
              >
                <View style={styles.userAvatarWrap}>
                  <Feather name="user" size={13} color={Colors.primaryDark} />
                </View>
                <Text style={styles.userNameHeader} numberOfLines={1}>
                  {user.name ? user.name.split(' ')[0] : 'Account'}
                </Text>
              </TouchableOpacity>
            ) : (
              <TouchableOpacity
                style={styles.signInHeaderBtn}
                activeOpacity={0.8}
                onPress={() => navigation.navigate('CustomerLogin')}
              >
                <Text style={styles.signInHeaderText}>{t('signIn')}</Text>
              </TouchableOpacity>
            )}

            <TouchableOpacity
              style={styles.headerCartBtn}
              activeOpacity={0.8}
              onPress={() => navigation.navigate('Cart')}
            >
              <Feather name="shopping-cart" size={19} color={Colors.primaryDark} />
              {totalItems > 0 && (
                <View style={styles.headerCartBadge}>
                  <Text style={styles.headerCartBadgeText}>{totalItems}</Text>
                </View>
              )}
            </TouchableOpacity>
          </View>
        </View>

        {/* Row 2: Location & ETA Bar matching website (.mobile-sub-row .mobile-location-bar) */}
        <TouchableOpacity
          style={styles.mobileLocationBar}
          activeOpacity={0.8}
          onPress={() => setLocationModalVisible(true)}
        >
          <View style={styles.mobileLocEta}>
            <Feather name="clock" size={12} color="#059669" />
            <Text style={styles.mobileLocEtaText}>{`${t('deliveryIn')} ${tEta('15–20 mins')}`}</Text>
          </View>
          <View style={styles.mobileLocAddress}>
            <Feather name="map-pin" size={12} color="#059669" style={{ flexShrink: 0 }} />
            <Text style={styles.addressDisplayText} numberOfLines={1}>
              {selectedLocation}
            </Text>
            <Feather name="chevron-down" size={12} color="#64748B" style={{ flexShrink: 0 }} />
          </View>
        </TouchableOpacity>

        {/* Row 3: Search Bar Input Trigger */}
        <TouchableOpacity
          style={styles.searchBarTrigger}
          activeOpacity={0.9}
          onPress={() => navigation.navigate('SearchTab')}
        >
          <Feather name="search" size={16} color="#64748B" style={styles.searchTriggerIcon} />
          <Text style={styles.searchTriggerText}>{t('searchPlaceholder')}</Text>
        </TouchableOpacity>
      </View>

      {/* Loading Skeleton Mode */}
      {loading ? (
        <View style={styles.skeletonContainer}>
          <BannerSkeleton />
          <CategoryGridSkeleton />
          <View style={styles.skeletonProductRow}>
            <ProductCardSkeleton width={PRODUCT_ITEM_WIDTH} />
            <ProductCardSkeleton width={PRODUCT_ITEM_WIDTH} />
          </View>
        </View>
      ) : (
        /* High-Performance Virtualized Single FlatList */
        <FlatList
          data={products}
          renderItem={renderProductItem}
          keyExtractor={item => item.id}
          numColumns={2}
          ListHeaderComponent={renderListHeader}
          contentContainerStyle={[
            styles.mainListContent,
            { paddingBottom: 110 + insets.bottom },
          ]}
          columnWrapperStyle={styles.productRowWrapper}
          initialNumToRender={6}
          maxToRenderPerBatch={6}
          windowSize={5}
          removeClippedSubviews={true}
          showsVerticalScrollIndicator={false}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} />}
        />
      )}

      {/* Floating Bottom Cart Bar */}
      <FloatingCartBar onPress={() => navigation.navigate('Cart')} />

      {/* Dynamic Location Selector Modal */}
      <Modal visible={locationModalVisible} transparent animationType="slide">
        <View style={styles.modalBackdrop}>
          <View style={styles.modalSheet}>
            <View style={styles.modalSheetHeader}>
              <View>
                <Text style={styles.modalHeading}>Select Delivery Location</Text>
                <Text style={styles.modalSubheading}>Delivery in 10-15 mins in Hathua & surrounding areas</Text>
              </View>
              <TouchableOpacity onPress={() => setLocationModalVisible(false)}>
                <Feather name="x" size={20} color="#64748B" />
              </TouchableOpacity>
            </View>

            <ScrollView showsVerticalScrollIndicator={false} style={{ maxHeight: 380 }}>
              {/* User Saved Addresses from backend if available */}
              {user && savedAddresses.length > 0 && (
                <View style={{ marginBottom: 16 }}>
                  <Text style={styles.modalSectionTitle}>Your Saved Addresses</Text>
                  {savedAddresses.map(addr => {
                    const label = `${addr.type || 'Home'} - ${addr.street || addr.landmark || addr.area || 'Hathua'}`;
                    const isSelected = selectedLocation === label;
                    return (
                      <TouchableOpacity
                        key={addr.id}
                        style={[styles.villageItem, isSelected && styles.villageItemActive]}
                        onPress={() => {
                          setSelectedLocation(label);
                          setLocationModalVisible(false);
                        }}
                      >
                        <View style={styles.villageItemLeft}>
                          <Feather
                            name={addr.type === 'WORK' ? 'briefcase' : 'home'}
                            size={16}
                            color={isSelected ? Colors.primaryDark : '#059669'}
                          />
                          <View style={{ marginLeft: 10, flex: 1 }}>
                            <Text style={[styles.villageName, isSelected && styles.villageNameActive]}>
                              {addr.type || 'Home'}
                            </Text>
                            <Text style={styles.addrSubText} numberOfLines={1}>
                              {[addr.houseNo, addr.street, addr.landmark, addr.area].filter(Boolean).join(', ')}
                            </Text>
                          </View>
                        </View>
                        {isSelected && <Feather name="check" size={18} color={Colors.primaryDark} />}
                      </TouchableOpacity>
                    );
                  })}
                  <TouchableOpacity
                    style={styles.addAddrBtn}
                    onPress={() => {
                      setLocationModalVisible(false);
                      navigation.navigate('Addresses');
                    }}
                  >
                    <Feather name="plus" size={14} color={Colors.primaryDark} />
                    <Text style={styles.addAddrBtnText}>+ Add New Address</Text>
                  </TouchableOpacity>
                </View>
              )}

              {/* Delivery Villages & Areas from backend */}
              <Text style={styles.modalSectionTitle}>Delivery Villages & Areas</Text>
              {(availableVillages.length > 0 ? availableVillages : ['Hathua Main Market', 'Station Road', 'Barwa Kaparpura', 'Mirganj Crossing']).map((v, idx) => {
                const isSelected = selectedLocation === v;
                return (
                  <TouchableOpacity
                    key={`loc_${idx}_${v}`}
                    style={[styles.villageItem, isSelected && styles.villageItemActive]}
                    onPress={() => {
                      setSelectedLocation(v);
                      setLocationModalVisible(false);
                    }}
                  >
                    <View style={styles.villageItemLeft}>
                      <Feather
                        name="map-pin"
                        size={16}
                        color={isSelected ? Colors.primaryDark : '#94A3B8'}
                      />
                      <Text style={[styles.villageName, isSelected && styles.villageNameActive]}>
                        {v}
                      </Text>
                    </View>
                    {isSelected && <Feather name="check" size={18} color={Colors.primaryDark} />}
                  </TouchableOpacity>
                );
              })}
            </ScrollView>
          </View>
        </View>
      </Modal>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#FFFFFF',
  },
  headerWrap: {
    backgroundColor: '#FFFFFF',
    paddingHorizontal: 16,
    paddingBottom: 10,
    borderBottomWidth: 1,
    borderBottomColor: '#F1F5F9',
  },
  topRow: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    marginBottom: 8,
  },
  logoImg: {
    width: 105,
    height: 38,
  },
  topRightActions: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 8,
  },
  langToggleBtn: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#ECFDF5',
    paddingVertical: 5,
    paddingHorizontal: 9,
    borderRadius: 16,
    borderWidth: 1,
    borderColor: '#A7F3D0',
    gap: 4,
  },
  langToggleText: {
    fontSize: 11.5,
    fontWeight: '800',
    color: '#047857',
  },
  userHeaderBtn: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#F8FAFC',
    paddingVertical: 5,
    paddingHorizontal: 10,
    borderRadius: 20,
    borderWidth: 1,
    borderColor: '#E2E8F0',
    gap: 6,
  },
  userAvatarWrap: {
    width: 24,
    height: 24,
    borderRadius: 12,
    backgroundColor: '#ECFDF5',
    alignItems: 'center',
    justifyContent: 'center',
  },
  userNameHeader: {
    fontSize: 12,
    fontWeight: '700',
    color: '#0F172A',
    maxWidth: 80,
  },
  signInHeaderBtn: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#ECFDF5',
    paddingVertical: 6,
    paddingHorizontal: 11,
    borderRadius: 20,
    borderWidth: 1,
    borderColor: '#A7F3D0',
    gap: 5,
  },
  signInHeaderText: {
    fontSize: 12,
    fontWeight: '700',
    color: Colors.primaryDark,
  },
  mobileLocationBar: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    backgroundColor: '#F8FAFC',
    paddingVertical: 7,
    paddingHorizontal: 12,
    borderRadius: 12,
    borderWidth: 1,
    borderColor: '#E2E8F0',
    marginBottom: 10,
  },
  mobileLocEta: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 5,
  },
  mobileLocEtaText: {
    fontSize: 11.5,
    fontWeight: '800',
    color: Colors.primaryDark,
    letterSpacing: 0.2,
  },
  mobileLocAddress: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 4,
    maxWidth: '55%',
  },
  addressDisplayText: {
    fontSize: 11.5,
    fontWeight: '600',
    color: '#334155',
  },
  headerCartBtn: {
    width: 40,
    height: 40,
    borderRadius: 20,
    backgroundColor: '#ECFDF5',
    alignItems: 'center',
    justifyContent: 'center',
    position: 'relative',
    borderWidth: 1,
    borderColor: '#D1FAE5',
  },
  headerCartBadge: {
    position: 'absolute',
    top: -4,
    right: -4,
    backgroundColor: '#EF4444',
    minWidth: 18,
    height: 18,
    borderRadius: 9,
    alignItems: 'center',
    justifyContent: 'center',
    paddingHorizontal: 4,
    borderWidth: 1.5,
    borderColor: '#FFFFFF',
  },
  headerCartBadgeText: {
    color: '#FFFFFF',
    fontSize: 10,
    fontWeight: '800',
  },
  searchBarTrigger: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#F1F5F9',
    borderRadius: 14,
    paddingHorizontal: 14,
    paddingVertical: 10,
    borderWidth: 1,
    borderColor: '#E2E8F0',
  },
  searchTriggerIcon: {
    marginRight: 8,
  },
  searchTriggerText: {
    fontSize: 13,
    color: '#64748B',
    fontWeight: '500',
  },
  skeletonContainer: {
    flex: 1,
    backgroundColor: '#FAFAF9',
  },
  skeletonProductRow: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    paddingHorizontal: 16,
    marginTop: 8,
  },
  mainListContent: {
    paddingBottom: 20,
  },
  storefrontHeader: {
    paddingHorizontal: 16,
    marginTop: 10,
    marginBottom: 8,
  },
  storefrontTitle: {
    fontSize: 17,
    fontWeight: '800',
    color: '#0F172A',
  },
  storefrontSub: {
    fontSize: 11.5,
    color: '#64748B',
    marginTop: 2,
  },
  productRowWrapper: {
    paddingHorizontal: 16,
    justifyContent: 'space-between',
  },
  floatingCartBar: {
    position: 'absolute',
    left: 16,
    right: 16,
    backgroundColor: Colors.primaryDark,
    borderRadius: 16,
    paddingVertical: 12,
    paddingHorizontal: 16,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    shadowColor: Colors.primaryDark,
    shadowOffset: { width: 0, height: 4 },
    shadowOpacity: 0.3,
    shadowRadius: 8,
    elevation: 8,
  },
  cartBarLeft: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  cartCounterBadge: {
    backgroundColor: '#FFFFFF',
    width: 28,
    height: 28,
    borderRadius: 14,
    alignItems: 'center',
    justifyContent: 'center',
    marginRight: 10,
  },
  cartCounterText: {
    color: Colors.primaryDark,
    fontSize: 13,
    fontWeight: '800',
  },
  cartBarTotal: {
    color: '#FFFFFF',
    fontSize: 15,
    fontWeight: '800',
  },
  cartBarSub: {
    color: '#A7F3D0',
    fontSize: 10.5,
  },
  cartBarRight: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  viewBasketText: {
    color: '#FFFFFF',
    fontSize: 14,
    fontWeight: '700',
  },
  modalBackdrop: {
    flex: 1,
    backgroundColor: 'rgba(0,0,0,0.5)',
    justifyContent: 'flex-end',
  },
  modalSheet: {
    backgroundColor: '#FFFFFF',
    borderTopLeftRadius: 24,
    borderTopRightRadius: 24,
    padding: 20,
    maxHeight: '60%',
  },
  modalSheetHeader: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'flex-start',
    marginBottom: 16,
  },
  modalHeading: {
    fontSize: 16,
    fontWeight: '800',
    color: '#0F172A',
  },
  modalSubheading: {
    fontSize: 11.5,
    color: '#64748B',
    marginTop: 2,
  },
  villageItem: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingVertical: 12,
    paddingHorizontal: 14,
    borderRadius: 12,
    marginBottom: 8,
    backgroundColor: '#F8FAFC',
    borderWidth: 1,
    borderColor: '#E2E8F0',
  },
  villageItemActive: {
    backgroundColor: '#ECFDF5',
    borderColor: Colors.primary,
  },
  villageItemLeft: {
    flexDirection: 'row',
    alignItems: 'center',
    flex: 1,
  },
  villageName: {
    fontSize: 13.5,
    color: '#334155',
    fontWeight: '500',
    marginLeft: 10,
  },
  villageNameActive: {
    color: Colors.primaryDark,
    fontWeight: '700',
  },
  modalSectionTitle: {
    fontSize: 12,
    fontWeight: '700',
    color: '#64748B',
    textTransform: 'uppercase',
    letterSpacing: 0.5,
    marginTop: 10,
    marginBottom: 8,
  },
  addrSubText: {
    fontSize: 11,
    color: '#64748B',
    marginTop: 2,
  },
  addAddrBtn: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    paddingVertical: 10,
    borderRadius: 10,
    borderWidth: 1,
    borderStyle: 'dashed',
    borderColor: Colors.primary,
    backgroundColor: '#F0FDF4',
    marginBottom: 12,
    gap: 6,
  },
  addAddrBtnText: {
    fontSize: 12.5,
    fontWeight: '700',
    color: Colors.primaryDark,
  },
});
