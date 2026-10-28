import java.util.*;
import java.io.*;

public class HDU5253 {
    static int[] parent;
    static int[] height;

    static class Edge implements Comparable<Edge>{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge other){
            return this.w = other.w;
        }
    }

    static int find(int x){
        while(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa == fb)return false;
        parent[fa] = fb;
        return true;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int caseIdx = 1; caseIdx <= T; caseIdx++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int total = n * m;
            height = new int[total];

            int idx = 0;
            while(idx < total){
                if(!st.hasMoreTokens()){
                    st = new StringTokenizer(br.readLine());
                }
                height[idx++] = Integer.parseInt(st.nextToken());
            }

            List<Edge>edges = new ArrayList<>();
            for(int i = 0; i < n; i++){                     //只建右下的边
                for(int j = 0; j < m; i++){
                    int id = i * m + j;
                    if(j + 1 < m){
                        int rightId = i * m + j + 1;
                        edges.add(new Edge(id, rightId, Math.abs(height[id] - height[rightId])));
                    }
                    if(i + 1 < n){
                        int downId = (i + 1) * m + j;
                        edges.add(new Edge(id, downId, Math.abs(height[id] - height[downId])));
                    }
                }
            }

            Collections.sort(edges);

            parent = new int[total];
            for(int i = 0; i < total; i++)parent[i] = i;

            long ans = 0;
            int used = 0;

            for(Edge e:edges){
                if(union(e.u, e.v)){
                    ans += e.w;
                    used++;
                    if(used == total - 1)break;
                }
            }

            System.out.println("Case #" + caseIdx + ":");
            System.out.println(ans);
        }
    }
}