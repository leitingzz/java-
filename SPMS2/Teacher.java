package SPMS2;

public class Teacher implements Printable{
    private String name;
    private String subject;

    public Teacher(String name, String subject){
        this.name = name;
        this.subject = subject;
    }

    @Override 
    public void printinfo(){
        System.out.println("教师姓名：" + name);
        System.out.println("授课课程：" + subject);
    }
}