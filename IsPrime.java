import java.util.Arrays;
import java.util.ArrayList;

public class IsPrime {
    
    public static boolean isPrime(int n){
        if(n <= 1)return false;
        if(n == 2)return true;
        if(n % 2 == 0)return false;
        for(int i = 3; i <= n / i; i += 2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static int[] creatArray(int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = i * i;
        }
        return arr;
    }
    public static void main(String[] args){
        ArrayList<Integer> prime = new ArrayList<>();
        for(int i = 1; i <= 50; i++){
            if(isPrime(i)){
                prime.add(i);
            }
        }
        System.out.println(Arrays.toString(creatArray(5)));
        System.out.println(prime);
    }
}