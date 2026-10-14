import java.io.*;
import java.util.*;

public class HDU4190 {
    static int[] city;
    static int N, B;

    static boolean check(int capacity){
        int boxes = 0;
        for(int population : city){
            boxes += (population + capacity - 1) / capacity;
            if(boxes > B){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            if (line.trim().isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);         //不指定分隔符，默认为空白字符
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if(N == -1 && B == -1){
                break;
            }

            city = new int[N];
            int max = 0;
            for(int i = 0; i < N; i++){
                city[i] = Integer.parseInt(br.readLine().trim());
                if(city[i] > max){
                    max = city[i];
                }
            }

            int left = 1, right = max;

            while(left < right){
                int mid = left + (right - left) / 2;
                if(check(mid)){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            System.out.println(left);
        }
    }
}