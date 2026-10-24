import java.util.*;

public class HDU1338 {
    public static void main(String[] args){
        int count = 1;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            if(m == 0 && n == 0)break;

            boolean[] isMine = new boolean[m * n + 1];
            for(int i = 0; i < n; i++){
                isMine[sc.nextInt()] = true;
            }

            int opponent = 0;
            int win = 0;

            for(int i = m * n; i > 0; i--){
                if(isMine[i]){
                    if(opponent > 0){
                        opponent--;
                    }else{
                        win++;
                    }
                }else{
                    opponent++;
                }
            }
            System.out.println("Case" + count + ":" + win);
            count++;
        }
        sc.close();
    }
}