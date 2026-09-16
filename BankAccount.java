import java.util.Scanner;
public class BankAccount {
    String holder;
    double blance;

    public BankAccount(String holder, double blance){
        this.holder = holder;
        this.blance = blance;
    }
    BankAccount bandAccount = new BankAccount("张三", 100);

    public static double deposit(double blance){
        System.out.println("请输入存入金额：");
        Scanner scanner = new Scanner(System.in);
        double account = scanner.nextInt();
        scanner.close();
        return blance + account;
    }

    public 
}
