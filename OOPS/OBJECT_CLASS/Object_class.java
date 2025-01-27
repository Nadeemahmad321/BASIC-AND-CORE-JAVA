package OOPS.OBJECT_CLASS;

class Car{
    String model;
    int year;
    public Car(String model,int year){
        this.model = model;
        this.year = year;
    }
    @Override
    public String toString(){
        return "Car model is " + model + " and year is " + year;
    }
    @Override
    public boolean equals(Object obj){
        Car that = (Car)obj;
        if(this.model == that.model && this.year == that.year){

        }
    }
}
public class Object_class{
    public static void main(String[] args){
        Car obj_1 = new Car("Honda",2021);
        Car obj_2 = new Car("Honda",2021);

        System.out.println(obj_1);
    }
}