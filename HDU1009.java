import java.util.*;
import java.io.*;

public class HDU1009 {
    static class Room implements Comparable<Room> {
        int j, f;
        double rate;
        
        public Room(int j, int f){
            this.j = j;
            this.f = f;
            this.rate = (double)j / f;
        }

        public int compareTo(Room other){
            return Double.compare(other.rate, this.rate);
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(m == -1 && n == -1)break;

            Room[] rooms = new Room[n];
            for(int i = 0; i < n; i++){
                if(!st.hasMoreTokens()){
                    st = new StringTokenizer(br.readLine());
                }
                int j = Integer.parseInt(st.nextToken());
                int f = Integer.parseInt(st.nextToken());
                rooms[i] = new Room(j, f);
            }

            Arrays.sort(rooms);

            double ans = 0.0;
            int remaining = m;

            for(int i = 0; i < n; i++){
                if(remaining >= rooms[i].f){
                    ans += rooms[i].j;
                    remaining -= rooms[i].j;
                }else{
                    ans += remaining * rooms[i].rate;
                    break;
                }
            }

            System.out.printf("%.3f%n",ans);
        }
    }
}