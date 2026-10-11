import java.util.Scanner;

public class HDU2199 {
    public static double f(double x){
        return 8 * x * x * x * x + 7 * x * x * x + 2 * x * x + 3 * x + 6;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while(T-- > 0){
            double Y = scanner.nextDouble();
            if(f(1) > Y || f(100) < Y){
                System.out.println("No solution!");
                continue;
            }
        }
    }
}
