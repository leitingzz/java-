import java.io.*;
import java.util.*;

public class POJ2456 {
    static int N, C;
    static int[] stalls;

    static boolean check(int d){
        int count = 1;
        int lastPos = stalls[0];
        for(int i = 1; i < N; i++){
            if(stalls[i] - lastPos >= d){
                count++;
                lastPos = stalls[i];
                if(count >= C){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        stalls = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            stalls[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(stalls);

        int left = 0, right = stalls[N - 1] - stalls[0];
        while(left < right){
            int mid = left + (right - left) / 2;
            if(check(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(left - 1);
    }
}