import java.io.*;
import java.util.*;

public class POJ3258 {
    static int L, N, M;
    static int[] rocks;

    static boolean check(int minDist){
        int remove = 0;
        int lastPos = 0;
        for(int i = 1; i <= N + 1; i++){
            if(rocks[i] - lastPos < minDist){
                remove++;
                if(remove > M){
                    return false;
                }
            }else{
                lastPos = rocks[i];
            }
        }
        return true;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rocks = new int[N + 2];
        rocks[0] = 0;
        rocks[N + 1] = L;
        for(int i = 1; i <= N; i++){
            rocks[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(rocks);

        int left = 0, right = L, ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(mid)){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}