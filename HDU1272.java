import java.io.*;
import java.util.*;

public class HDU1272 {
    static final int MAXN = 100005;
    static int[] parent = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static boolean hasCycle;

    static int find(int x) {
        int root = x;
        while (parent[root] != root) root = parent[root];
        while (parent[x] != root) {
            int next = parent[x];
            parent[x] = root;
            x = next;
        }
        return root;
    }

    static void union(int a, int b) {
        int fa = find(a), fb = find(b);
        if (fa == fb) hasCycle = true;
        else parent[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        while (true) {
            while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;
            if (a == 0 && b == 0) {
                System.out.println("Yes");
                continue;
            }

            for (int i = 1; i <= 100000; i++) {
                parent[i] = i;
                vis[i] = false;
            }
            hasCycle = false;

            vis[a] = vis[b] = true;
            union(a, b);

            while (true) {
                while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if (a == 0 && b == 0) break;
                vis[a] = vis[b] = true;
                union(a, b);
            }

            if (hasCycle) System.out.println("No");
            else {
                int cnt = 0;
                for (int i = 1; i <= 100000; i++)
                    if (vis[i] && parent[i] == i) cnt++;
                System.out.println(cnt == 1 ? "Yes" : "No");
            }
        }
    }
}