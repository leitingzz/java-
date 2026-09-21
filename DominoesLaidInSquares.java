import java.util.Scanner;
public class DominoesLaidInSquares {
    public static void main(String[] args){
        long[] arr = new long[51];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= 50; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int number = scanner.nextInt();
            System.out.println(arr[number]);
        }
        scanner.close();
    }
}