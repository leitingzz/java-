public class Main {
    public static void main(String[] args){
        Dog dog1 = new Dog();
        dog1.name = "大狗";
        dog1.age = 10;
        dog1.sex = "male";
        Dog dog2 = new Dog();
        dog2.name = "小狗";
        dog2.age = 5;
        dog2.sex = "female";
        dog1.bark();
        dog2.bark();
    }
}