public class BankAccount {
    String holder;
    double balance;

    public BankAccount(String holder, double balance){
        this.holder = holder;
        this.balance = balance;
    }

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
}
