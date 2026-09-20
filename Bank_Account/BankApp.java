import java.util.Scanner;

public class BankApp{
    /**
     * @param args
     */
    public static void main(String[] args){     //多态：声明类型=实际类型，多态中使用的方法只能是声明类型中的方法，但是会运行实际类型中重写的方法
        BankAccount account = new SavingAccount("张三", 1000, 0.05);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("1.存款  2取款  3.查询余额  4.退出  5.结算利息");
            int choice = -1;
            
            try {
                choice = scanner.nextInt();               //可能出错的代码
            } catch (Exception e) {
                System.out.println("输入无效，请重新输入！");           //处理异常
                scanner.nextLine();         //清除错误内容：错误的输入内容还留在输入缓冲区里，没被读走，下一次循环再调用nextInt()会立刻又读到同样的垃圾内容，再次报错，陷入死循环。
                continue;
            }

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
                    //account.addinterest();      //父类不能使用
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