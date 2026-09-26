package fileReadAndWrite;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public void writing(){
        try{
            FileWriter writer = new FileWriter("student.txt");
            writer.write("张三，1001，90\n");
            writer.write("李四，1002，85\n");
            writer.close();
        }catch(IOException e){
            System.out.println("写文件失败：" + e.getMessage());
        }
    }
}