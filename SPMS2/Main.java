package SPMS2;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Printable> everyone = new ArrayList<>();

        Student s1 = new Student ("zh", 10, 90);
        Teacher t1 = new Teacher("lwh", "math");

        everyone.add(s1);
        everyone.add(t1);
        
        for(Printable p : everyone){
            p.printinfo();
        }
    }
}