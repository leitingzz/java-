public class println {
    public static void main(String[] args){
        String name = "张三";
        int age = 20;
        double gpa = 3.8;
        System.out.println("我叫" + name + ",今年" + age + ",GPA是" + gpa);
        int a = 7;
        int b = 2;
        System.out.println("两数之和为：" + (a + b));
        System.out.println("两数之差为：" + (a - b));
        System.out.println("两数之积为：" + (a * b));
        System.out.println("两数之商为：" + ((double)a / b));
    }
}