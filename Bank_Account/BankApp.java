import java.util.Scanner;

public class BankApp{
    public static void main(String[] args){
        BankAccount account = new SavingAccount("张三", 1000, 0.05);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("1.存款  2取款  3.查询余额  4.退出  5.结算利息");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("请输入存款金额：");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
            
                case 2:
                    System.out.println("请输入取款金额：");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.showBalance();
                    break;

                case 4:
                    running = false;
                    System.out.println("再见！");
                    break;
                
                case 5:
                    account.addinterest();
                    account.settle();
                    break;

                default:
                    System.out.println("无效选项，请重新输入！");
                    break;
            }
        }
        scanner.close();
    }
}