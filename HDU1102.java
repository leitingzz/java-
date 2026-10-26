import java.util.*;

public class HDU1102 {
    static  int[] parent;

    static int find(int x){
        if(parent[x] != x){
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

    static class Edge implements Comparable<Edge> {    
        int u,v,w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge other){
            return this.w - other.w;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[][] dist = new int[n + 1][n + 1];
            List<Edge> edges = new ArrayList<>();

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    dist[i][j] = sc.nextInt();
                    if(i < j){
                        edges.add(new Edge(i, j, dist[i][j]));          //邻接矩阵对称，只建一条边(存长度)
                    }
                }
            }

            parent = new int[n + 1];            ///初始化并查集
            for(int i = 1; i <= n; i++)parent[i] = i;
            
            int q = sc.nextInt();
            for(int i = 0; i < q; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                union(a, b);
            }

            Collections.sort(edges);

            int ans = 0;
            for(Edge e:edges){
                if(union(e.u, e.v)){
                    ans += e.w;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}