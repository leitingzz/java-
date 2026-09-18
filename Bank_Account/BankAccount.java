public class BankAccount {
    protected  String holder;              //protected:一个新的访问级别，子类能访问，但完全外部代码不能——专门为继承设计的
    protected double balance;

    public BankAccount(String holder, double balance){
        this.holder = holder;
        this.balance = balance;
    }

    //getter:外部只能“读”，读不到可修改的入口
    public double getBalance(){
        return balance;
    }

    public String getHolder(){
        return holder;
    }

    //已有的deposit/withdraw方法本身就是唯一能改balance的入口
    public void deposit(double depositAmount){
        balance += depositAmount;
    }

    public void withdraw(double withdrawAmount){
        if(balance < withdrawAmount){
            System.out.println("余额不足！");
        }else{
            balance -= withdrawAmount;
        }
    }

    public void showBalance(){
        System.out.println(balance);
    }   

    public void settle(){
        System.out.println("普通账户，无需特殊结算！");
    }
}
