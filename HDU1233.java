import java.util.*;
import java.io.*;

public class HDU1233 {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge other){
            return this.w - other.w;
        }
    }

    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b){
        parent[find(a)] = parent[find(b)];
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        while(true){
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }

            int n = Integer.parseInt(st.nextToken());
            if(n == 0)break;

            int m = n * (n - 1) / 2;
            Edge[] edges = new Edge[m];

            for(int i = 0; i < m; i++){
                while(!st.hasMoreTokens()){
                    st = new StringTokenizer(br.readLine());
                }
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(u, v, w);
            }

            Arrays.sort(edges);

            parent = new int[n + 1];
            for(int i = 1; i <= n; i++)parent[i] = i;

            int ans = 0, count = 0;
            for(Edge e:edges){
                if(find(e.u) != find(e.v)){
                    union(e.u, e.v);
                    ans += e.w;
                    count++;
                    if(count == n - 1)break;
                }
            }
            System.out.println(ans);
        }
    }
}