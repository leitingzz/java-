package fileReadAndWrite;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;;

public class Main {

    public static void reading(){
        try{
            Scanner scanner = new Scanner(new File("fileReadAndWrite/student.txt"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String [] parts = line.split(",");      //按分隔符把一行拆成数组
                int id = Integer.parseInt(parts[0]);
                int total = 0;
                ArrayList<Integer> scores = new ArrayList<>();
                for(int i = 2; i < parts.length; i++){
                    scores.add(Integer.parseInt(parts[i]));
                    total += Integer.parseInt(parts[i]);
                }
                System.out.println(id + parts[1] + scores + "总分:" + total);
            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("文件不存在：" + e.getMessage());
        }
    }
 
    public static void writing(){
        try{
            FileWriter writer = new FileWriter("fileReadAndWrite/student.txt");
            writer.write("1001,张三,90\n");
            writer.write("1002,李四,85\n");
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