import java.util.*;

public class HDU6011 {
    static class Node implements Comparable<Node> {
        int val, cnt;
        Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
        public int compareTo(Node other) {
            // 从大到小排序：价值大的放后面（位权高）
            return Integer.compare(other.val, this.val);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Node[] a = new Node[n];
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                int cnt = sc.nextInt();
                a[i] = new Node(val, cnt);
            }

            Arrays.sort(a);

            long ans = 0;
            long sum = 0; // 当前已加入字符的价值和（从后往前累计）

            outer:
            for (Node node : a) {
                for (int i = 0; i < node.cnt; i++) {
                    sum += node.val;
                    if (sum < 0) {
                        // 继续加入只会让答案变小，停止
                        break outer;
                    }
                    ans += sum;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}