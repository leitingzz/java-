import java.util.Scanner;

public class HDU2289 {
    static double r, R, H, V; 
    static final double PI = Math.acos(-1.0);       //反余弦函数
    static final double EPS = 1e-9; 

    static double calcVolume(double h) {
        double rTop = r + (R - r) * h / H; 
        return PI / 3.0 * h * (r * r + rTop * rTop + r * rTop);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            r = sc.nextDouble();
            R = sc.nextDouble();
            H = sc.nextDouble();
            V = sc.nextDouble();

            // 如果水体积大于等于杯子总容积，高度就是杯高
            double totalVol = PI / 3.0 * H * (r * r + R * R + r * R);
            if (V >= totalVol) {
                System.out.printf("%.6f\n", H);
                continue;
            }

            double left = 0.0, right = H;
            double mid = 0.0;

            while (right - left > EPS) {
                mid = (left + right) / 2.0;
                if (calcVolume(mid) < V) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            System.out.printf("%.6f\n", mid);
        }
        sc.close();
    }
}