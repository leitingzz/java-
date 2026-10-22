import java.util.*;
import java.io.*;

public class POJ3190 {
    static class Cow implements Comparable<Cow>{
        int start, end, id, stall;

        Cow(int start, int end, int id){
            this.start = start;
            this.end = end;
            this.id = id;
        }

        public int compareTo(Cow other){            //按优先顺序排序（服务窗口）
            if(this.end != other.end){
                return Integer.compare(this.end, other.end);
            }else{
                return Integer.compare(this.start, other.start);
            }
        }
    }    

    public static void main(String[] arhs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Cow[] cows = new Cow[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(a, b, i);
        }

        Arrays.sort(cows, (c1, c2)->{           //按开始时间排序（服务对象）    Arrays.sort(数组，比较器)用法
            if(c1.start != c2.start){
                return Integer.compare(c1.start, c2.start);
            }else{
                return Integer.compare(c1.end, c2.end);
            }
        });

        PriorityQueue<Cow> pq = new PriorityQueue<>();          //优先队列，只保证队首元素优先级最高
        int stallCount = 0;

        cows[0].stall = ++stallCount;
        pq.offer(cows[0]);

        for(int i = 1; i < n; i++){
            Cow current = cows[i];
            Cow earliest = pq.peek();

            if(earliest.end < current.start){
                pq.poll();                          //弹出
                current.stall = earliest.stall;
            }else{
                current.stall = ++stallCount;
            }
            pq.offer(current);                      //插入
        }

        int[] result = new int[n];
        for(Cow cow:cows){
            result[cow.id] = cow.stall;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(stallCount).append("\n");
        for(int i = 0; i < n; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}