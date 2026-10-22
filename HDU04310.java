import java.util.*;

public class HDU04310 {
    static class Enemy implements Comparable<Enemy> {
        int dps;
        int hp;
        
        public Enemy(int dps, int hp){
            this.dps = dps;
            this.hp = hp;
        }

        public int compareTo(Enemy other){
            long left = (long)this.dps * other.hp;
            long right = (long)other.dps * this.hp;
            return Long.compare(right, left);           //降序，（right-left）为负则this排前面
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            Enemy[] enemies = new Enemy[n];
            long totalDps = 0;

            for(int i = 0; i < n; i++){
                int dps = sc.nextInt();
                int hp = sc.nextInt();
                enemies[i] = new Enemy(dps, hp);
                totalDps += dps;
            }

            Arrays.sort(enemies);

            long minLoss = 0;
            for(Enemy enemy:enemies){
                minLoss += totalDps * enemy.hp;
                totalDps -= enemy.dps;
            }
            System.out.println(minLoss);
        }
        sc.close();
    }
}