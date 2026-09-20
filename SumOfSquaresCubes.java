import java.util.Scanner;
public class SumOfSquaresCubes {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {           
            int squares = 0;
            int cubes = 0;
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if(left > right){
                int temp = right;
                right = left;
                left = temp;
            }
            for(int i = left; i <= right; i++){
                if(i % 2 == 0){
                    squares += i * i;
                }else{
                    cubes += i * i * i;
                }
            }
            System.out.println(squares + " " + cubes);
        }
        scanner.close();
    }
}