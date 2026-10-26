import java.util.*;
import java.io.*;

public class HDU1272 {
    static int[] parent = new int[100005];
    static boolean[] vis = new boolean[100005];
    static boolean hasCycle;

    static int find(int x){
        int root  = x;                                      //不用递归，避免递归深度过大导致爆栈
        while(parent[root] != root)root = parent[root];     //一路向上找根
        while(parent[x] != root){                           //把路径上的所有点直接挂到根下
            int next = parent[x];
            parent[x] = root;
            x = next;
        }
        return root;
    }

    static void union(int a, int b){
        int fa = find(a), fb = find(b);
        if(fa == fb){                               //根相同->已连通->这条边成环
            hasCycle = true;
        }else{                                      //否则把一个根挂到另一个根下
            parent[fa] = fb;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        while(true){
            while(!st.hasMoreTokens()){
                String line = br.readLine();
                if(line == null)return;
                st = new StringTokenizer(line);
            }
            int a = Integer.parseInt(st.nextToken());

            while(!st.hasMoreTokens()){
                String line = br.readLine();
                if(line == null)return;
                st = new StringTokenizer(line);
            }
            int b = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1)break;
            if(a == 0 && b == 0){
                System.out.println("Yes");
                continue;
            }

            for(int i = 1; i <= 100000; i++){
                parent[i] = i;
                vis[i] = false;
            }
            hasCycle = false;

            vis[a] = true;
            vis[b] = true;
            union(a, b);

            while(true){
                while(!st.hasMoreTokens()){
                    String line = br.readLine();
                    if(line == null)return;
                    st = new StringTokenizer(line);
                }
                a = Integer.parseInt(st.nextToken());

                while(!st.hasMoreTokens()){
                    String line = br.readLine();
                    if(line == null)return;
                    st = new StringTokenizer(line);
                }
                b = Integer.parseInt(st.nextToken());

                if(a == 0 && b == 0)break;
                vis[a] = true;
                vis[b] = true;
                union(a, b);
            }

            if(hasCycle){
                System.out.println("No");
            }else{
                int cnt = 0;
                for(int i = 1; i <= 100000; i++){
                    if(vis[i] && parent[i] == i)cnt++;                  //根节点
                    System.out.println(cnt == 1 ? "Yes" : "No");
                }
            }
        }
    }
}