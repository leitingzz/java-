package fileReadAndWrite;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read {
    public void reading(){
        try{
            Scanner scanner = new Scanner(new File("student.txt"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("文件不存在：" + e.getMessage());
        }
    }
}