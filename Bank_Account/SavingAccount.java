public class SavingAccount extends BankAccount{         //extends:子类声明继承父类，子类自动拥有父类的字段和方法
    private double interestRate;                        //private:只有这个类内部能直接访问(封装)
    
    public SavingAccount(String holder, double balance, double interestRate){
        super(holder, balance);                 //调用父类的构造方法，因为父类的字段初始化逻辑不能被跳过，必须写在子类构造方法的第一行
        this.interestRate = interestRate;
    }

    public void addinterest(){
        balance += balance * interestRate;
    }

    public void settle(){
        System.out.println("储蓄账户结算完成，已结算利息！");
    }
}