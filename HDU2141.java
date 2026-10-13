import java.util.*;
import java.io.*;

public class HDU2141 {
    static int[] a, b, c, sumAB;
    static int L, N, M, S, size;
    
    static boolean search(int target){
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(sumAB[mid] == target){
                return true;
            }else if(sumAB[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       //加速输入
        StringBuilder sb = new StringBuilder();           //内部是一个可变字符数组，拼接时直接在数组后面追加，不新建对象
        String line;
        int caseNum = 1;

        while((line = br.readLine()) != null){
            line = line.trim();             //去掉字符串首尾空白字符
            if(line.isEmpty()){
                continue;               //判断字符串是不是空串，有空格也不算空串
            }

            String[] parts = line.split("\\s+");           //将line按一个或多个空白字符切成字符数组
            L = Integer.parseInt(parts[0]);
            N = Integer.parseInt(parts[1]);
            M = Integer.parseInt(parts[2]);

            a = new int[L];
            b = new int[N];
            c = new int[M];

            parts = br.readLine().trim().split("\\s+");
            for(int i = 0; i < L; i++){
                a[i] = Integer.parseInt(parts[i]);
            }
            
            parts = br.readLine().trim().split("\\s+");
            for(int i = 0; i < N; i++){
                b[i] = Integer.parseInt(parts[i]);
            }
            
            parts = br.readLine().trim().split("\\s+");
            for(int i = 0; i < M; i++){
                c[i] = Integer.parseInt(parts[i]);
            }

            sumAB = new int[L * N];
            size = 0;
            for(int i = 0; i < L; i++){
                for(int j = 0; j < N; j++){
                    sumAB[size++] = a[i] + b[j];
                }
            }
            Arrays.sort(sumAB);

            S = Integer.parseInt(br.readLine().trim());

            sb.append("Case ").append(caseNum++).append(":\n");

            for(int q = 0; q < S; q++){
                int X = Integer.parseInt(br.readLine().trim());
                boolean found = false;

                for(int k = 0; k < M; k++){
                    int target = X - c[k];
                    if(search(target)){
                        found = true;
                        break;
                    }
                }

                sb.append(found ? "YES" : "NO").append("\n");
            }
        }
        System.out.print(sb);
    }
} 