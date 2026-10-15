import java.io.*;

public class POJ1505 {
    static int[] books;
    static boolean[] cut;
    static int m, k;

    static boolean check(long mid) {
        int cnt = 1;
        long sum = 0;
        for (int i = m - 1; i >= 0; i--) {
            if (sum + books[i] > mid) {
                cnt++;
                sum = books[i];
            } else {
                sum += books[i];
            }
        }
        return cnt <= k;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int N = (int) st.nval;
        while (N-- > 0) {
            st.nextToken();
            m = (int) st.nval;
            st.nextToken();
            k = (int) st.nval;
            books = new int[m];
            long left = 0, right = 0;
            for (int i = 0; i < m; i++) {
                st.nextToken();
                books[i] = (int) st.nval;
                left = Math.max(left, books[i]);
                right += books[i];
            }

            long ans = right;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (check(mid)) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            cut = new boolean[m];
            int people = 1;
            long sum = 0;
            for (int i = m - 1; i >= 0; i--) {
                if (sum + books[i] > ans || i < k - people) {
                    cut[i] = true;
                    people++;
                    sum = books[i];
                } else {
                    sum += books[i];
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                if (i > 0) sb.append(" ");
                sb.append(books[i]);
                if (cut[i] && i < m - 1) sb.append(" /");
            }
            System.out.println(sb.toString());
        }
    }
}