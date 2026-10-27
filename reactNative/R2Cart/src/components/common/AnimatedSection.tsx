import React, { useRef, useEffect, ReactNode } from 'react';
import { Animated } from 'react-native';

interface AnimatedSectionProps {
  children: ReactNode;
  /** Delay in ms before animation starts — use staggered values for waterfall effect */
  delay?: number;
  /** Spring tension — higher = snappier zoom */
  tension?: number;
  /** Spring friction — higher = less bounce */
  friction?: number;
  /** Starting scale value (default 0.88) */
  initialScale?: number;
}

/**
 * AnimatedSection — Zoom In + Fade In on mount.
 * Wraps any section/component and animates it into view with a
 * smooth scale (initialScale → 1) + opacity (0 → 1) spring.
 *
 * Usage:
 *   <AnimatedSection delay={200}>
 *     <MySection />
 *   </AnimatedSection>
 */
export const AnimatedSection: React.FC<AnimatedSectionProps> = ({
  children,
  delay = 0,
  tension = 75,
  friction = 10,
  initialScale = 0.88,
}) => {
  const scale = useRef(new Animated.Value(initialScale)).current;
  const opacity = useRef(new Animated.Value(0)).current;

  useEffect(() => {
    const animation = Animated.parallel([
      Animated.spring(scale, {
        toValue: 1,
        delay,
        tension,
        friction,
        useNativeDriver: true,
      }),
      Animated.timing(opacity, {
        toValue: 1,
        duration: 320,
        delay,
        useNativeDriver: true,
      }),
    ]);

    animation.start();

    return () => animation.stop();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <Animated.View
      style={{
        opacity,
        transform: [{ scale }],
      }}
    >
      {children}
    </Animated.View>
  );
};

/**
 * AnimatedGridItem — Lightweight zoom-in for FlatList product grid cards.
 * Uses a slightly shorter animation so scrolled items feel snappy.
 */
export const AnimatedGridItem: React.FC<{ children: ReactNode; index: number }> = ({
  children,
  index,
}) => {
  const scale = useRef(new Animated.Value(0.85)).current;
  const opacity = useRef(new Animated.Value(0)).current;

  useEffect(() => {
    // Slight stagger between the two columns
    const stagger = (index % 2) * 60;

    const animation = Animated.parallel([
      Animated.spring(scale, {
        toValue: 1,
        delay: stagger,
        tension: 90,
        friction: 11,
        useNativeDriver: true,
      }),
      Animated.timing(opacity, {
        toValue: 1,
        duration: 280,
        delay: stagger,
        useNativeDriver: true,
      }),
    ]);

    animation.start();

    return () => animation.stop();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <Animated.View style={{ opacity, transform: [{ scale }] }}>
      {children}
    </Animated.View>
  );
};
