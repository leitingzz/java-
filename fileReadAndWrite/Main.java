package fileReadAndWrite;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void reading(){
        try{
            Scanner scanner = new Scanner(new File("fileReadAndWrite/student.txt"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("文件不存在：" + e.getMessage());
        }
    }

    public static void writing(){
        try{
            FileWriter writer = new FileWriter("fileReadAndWrite/student.txt");
            writer.write("张三，1001，90\n");
            writer.write("李四，1002，85\n");
            writer.close();
        }catch(IOException e){
            System.out.println("写文件失败：" + e.getMessage());
        }
    }
    public static void main(String[] args){
        writing();
        reading();
    }
}