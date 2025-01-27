package OOPS.INHERITANCE;

class Parent{
    String firstName;
    int age;
    String lastName;

    public Parent(String firstName,int age,String lastName){
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
    }
    
    void personProperties(){
        System.out.println("First name:" + firstName);
        System.out.println("Last name:" +lastName);
        System.out.println("Age:" + age);
    }
}
class Child extends Parent{
    int yearOfBirth;

    public Child(String firstName,int age,String lastName,int yearOfBirth){
        super(firstName,age,lastName);
        this.yearOfBirth = yearOfBirth;
    }
    void childProperties(){
        System.out.println("Year of Birth:" + yearOfBirth);
    }

}
public class Single_Ineritance {
    public static void main(String[] args){
        Parent ramesh = new Parent("Ramesh",45,"Kumar");
        ramesh.personProperties();

        Child rakesh = new Child("Rakesh",24,"Kumar",2000);
        rakesh.personProperties();
        rakesh.childProperties();
    }
}
