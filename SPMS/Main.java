package SPMS;
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
        System.out.println("0.退出  1.添加学生  2.录入成绩  3.查询  4.打印全部");
        boolean running = true;
        ArrayList<Student> students = new ArrayList<>();

        while(running){
            int choice;
            int id;
            int score;
            Student targetStudent;

            try{
                choice = scanner.nextInt();
            }catch(Exception e){
                System.out.println("输入无效，请重试！");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 0:
                    System.out.println("再见！");
                    running = false;
                    break;
                
                case 1:
                    System.out.println("请输入学生姓名：");
                    String name = scanner.nextLine();
                    System.out.println("请输入学生学号：");
                    id = scanner.nextInt();
                    Student s1 = new Student(name, id, new ArrayList<Integer>());
                    students.add(s1);
                    break;

                case 2:
                    System.out.println("请输入学生id：");
                    id = scanner.nextInt();
                    targetStudent = findStudentById(students, id);
                    if(targetStudent == null){
                        System.out.println("该学生不存在！");
                        break;
                    }
                    System.out.println("请输入学生成绩：");
                    score = scanner.nextInt();
                    targetStudent.addScore(score);
                    break;
                
                case 3:
                    System.out.println("请输入学生id：");
                    id = scanner.nextInt();
                    targetStudent = findStudentById(students, id);
                    if(targetStudent == null){
                        System.out.println("该学生不存在！");
                        break;
                    }
                    
                default:
                    break;
            }
        }
    }
}
