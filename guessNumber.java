import java.util.Scanner;
public class guessNumber {
    public static void main(String[] args){
        int ans = 50;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的猜测：");
        int guess = scanner.nextInt();
        if(guess > ans){
            System.out.println("猜大了！");
        }else if(guess < ans){
            System.out.println("猜小了！");
        }else{
            System.out.println("猜对了！");
        }
        scanner.close();
    }
}