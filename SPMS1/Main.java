package SPMS1;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static Student findStudentById(ArrayList<Student> students, int id){
        for(Student s : students){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        ArrayList<Student> student = new ArrayList<>();
        
        while(running){
            int choice;
            int id;
            int score;
            String name;
            Student targetStudent;

            System.out.println("0.退出  1.添加学生  2.录入成绩  3.查询  4.打印全部");

            try{
                choice = scanner.nextInt();
            }catch(Exception e){
                System.out.println("输入无效，请重试！");
                continue;
            }
            
            switch (choice) {
                case 0:
                    System.out.println("再见！");
                    running = false;
                    break;
                    
                    case 1:
                    System.out.println("请输入学生学号：");
                    id = scanner.nextInt();

                    if(findStudentById(student, id) != null){
                        System.out.println("该学号已存在！");
                        break;
                    }
                    
                    scanner.nextLine();             //吃掉上次nextInt（）留下的换行符，因为后面name = nextLine会读取
                    System.out.println("请输入学生姓名：");
                    name = scanner.nextLine();
                    Student s1 = new Student(name, id, new ArrayList<Integer>());
                    student.add(s1);
                    break;

                case 2:
                    System.out.println("请输入学生id：");
                    id = scanner.nextInt();
                    targetStudent = findStudentById(student, id);
                    if(targetStudent == null){
                        System.out.println("该学生不存在！");
                        break;
                    }
                    System.out.println("请输入学生成绩：");
                    try{
                        score = scanner.nextInt();
                        targetStudent.addScore(score);
                    }catch(Exception e){
                        System.out.println("输入不合法！");
                        scanner.nextLine();
                    }
                    break;
                
                case 3:
                    System.out.println("请输入学生id：");
                    id = scanner.nextInt();
                    targetStudent = findStudentById(student, id);
                    if(targetStudent == null){
                        System.out.println("该学生不存在！");
                        break;
                    }
                    targetStudent.printinfo();
                    break;

                case 4:
                    for(Student s : student){
                        s.printinfo();
                    }
                    break;

                default:
                    break;
            }
        }
        scanner.close();
    }
}