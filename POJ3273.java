import java.io.*;
import java.util.*;

public class POJ3273 {
    static int[] money;
    static int n, m;

    static boolean check(int left){
        int count = 1;
        int sum = 0;

        for(int i = 0; i < n; i++){
            if((sum + money[i]) <= left){
                sum += money[i];

            }else{
                count++;
                sum = money[i];
            }
        }
        return count <= m;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        money = new int[n];

        int left = 0;
        int right = 0;
        int ans = 0;

        for(int i = 0; i < n; i++){
            money[i] = Integer.parseInt(br.readLine().trim());
            right += money[i];
            if(money[i] > left)left = money[i];
        }

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(mid)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}