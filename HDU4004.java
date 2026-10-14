import java.io.*;
import java.util.*;

public class HDU4004 {
    static int L, n, m;
    static int[] stone;

    static boolean check(int jump){
        if(jump * m < L)return false;
        int current = 0;
        int count = 0;

        while(current < n + 1){
            count++;
            if(count > m)return false;

            int next = current;
            while(next + 1 <= n + 1 && stone[next + 1] - stone[current] <= jump){
                next++;
            }
            if(next == current)return false;
            current = next;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            StringTokenizer st = new StringTokenizer(line);
            L = Integer.parseInt(st.nextToken());            
            n = Integer.parseInt(st.nextToken());            
            m = Integer.parseInt(st.nextToken());
            
            stone = new int[n + 2];
            stone[0] = 0;
            stone[n + 1] = L;

            int idx = 1;
            while (idx <= n) {
                if(!st.hasMoreTokens()){
                    st = new StringTokenizer(br.readLine());
                }
                stone[idx++] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(stone);

            int left = 1, right = L, ans = L;

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
}