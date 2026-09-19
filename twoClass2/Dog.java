package twoClass2;

public class Dog {
    String name;
    int age;
    String sex;

    public Dog(String name, int age, String sex){       //构造方法
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void bark(){
        System.out.println("汪汪！我是" + name);
    }
}
