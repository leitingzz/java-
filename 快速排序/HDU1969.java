import java.util.Scanner;

public class HDU1969 {
    static int n, f;
    static double[] pie;
    static final double PI = Math.acos(-1.0);

    static boolean check(double x){
        int count = 0;
        for(double v : pie){
            count += (int)(v / x);
        }
        return count >= f;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            f = sc.nextInt();
            f += 1;

            pie = new double[n];
            double sum = 0;
            for(int i = 0; i < n; i++){
                double r = sc.nextDouble();
                pie[i] = PI * r * r;
                sum += pie[i];
            }

            double left = 0;
            double right = sum / f;

            for(int i = 0; i < 100; i++){
                double mid = left + (right - left) / 2;
                if(check(mid)){
                    left = mid;
                }else{
                    right = mid;
                }
            }
            System.out.printf("%.4f\n", left);
        }
        sc.close();
    }
}