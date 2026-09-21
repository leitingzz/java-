import java.util.Scanner;
public class SumOfTwoTimes {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int ammount = scanner.nextInt();
        for(int i = 0; i < ammount; i++){
            int hours = 0, minutes = 0, seconds = 0;
            for(int j = 0; j < 2; j++){
                int hour = scanner.nextInt();
                int minute = scanner.nextInt();
                int second = scanner.nextInt();
                hours += hour;
                minutes += minute;
                seconds += second;
            }
            int temp = seconds / 60;
            seconds = seconds % 60;
            temp = (minutes + temp) / 60;
            minutes = (minutes + temp) % 60;
            hours = hours + temp;
            System.out.println(hours + " " + minutes + " " + seconds);
        }
        scanner.close();
    }
}