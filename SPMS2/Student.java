package SPMS2;

public class Student implements Printable{
    
    private String name;
    private int id;
    private int score;

    public Student (String name, int id, int score){
        this.name = name;
        this.id = id;
        this.score = score;
    }

    @Override       //写在重写父类或接口的方法前面，编译器检查方法签名是否错误
    public void printinfo(){
        System.out.println("学生姓名：" + name);
        System.out.println("学生id：" + id);
        System.out.println("学生成绩：" + score);
    }
}