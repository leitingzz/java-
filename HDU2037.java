import java.util.*;

public class HDU2037 {
    static class Program implements Comparable<Program> {       //系统自带的接口
        int start;
        int end;
        
        Program(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        @Override 
        public int compareTo(Program other){
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            if(n == 0)break;
            Program[] programs = new Program[n];
            for(int i = 0; i < n; i++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                programs[i] = new Program(s, e);
            }
            Arrays.sort(programs);
            int count = 0;
            int lastEnd = 0;
            for(Program program : programs){
                if(program.start >= lastEnd){
                    count++;
                    lastEnd = program.end;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}