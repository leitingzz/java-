import java.util.Scanner;

public class NumericalStatistics {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {          //判断下一个输入的是否为整数
            int n = scanner.nextInt();
            if(n == 0){
                break;
            }
            int positive = 0, nagtive = 0, zore = 0;
            for(int i = 0; i < n; i++){
                double m = scanner.nextDouble();
                if(m > 0){
                    positive++;
                }else if(m < 0){
                    nagtive++;
                }else{
                    zore++;
                }
            }
            System.out.println(nagtive + " " + zore + " " + positive);
        }
        scanner.close();
    }
}