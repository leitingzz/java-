import java.util.Scanner;
import java.util.Arrays;
public class ASCllCodeSorting {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();            //读取一行（无空格）
            char[] arr = str.toCharArray();         //转为字符数组
            Arrays.sort(arr);                       //按ASCll码升序排序
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
        scanner.close();
    }
}