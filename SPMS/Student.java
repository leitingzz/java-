package SPMS;
import java.util.ArrayList;

public class Student{
    private String name;
    private int id;
    private ArrayList<Integer> scores;

    public Student(String name, int id, ArrayList<Integer> scores){
        this.name = name;
        this.id = id;
        this.scores = scores;
    }

    public void addScore(int score){
        if(score < 0 || score > 100){
            System.out.println("成绩不合法！");
            return;
        }
        scores.add(score);
    }

    public double getAverage(){
        if (scores.size() == 0){
            return 0;
        }
        int total = 0;
        for(int score : scores){
            total += score;
        }
        double average = (double)total / scores.size();
        return average;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public ArrayList<Integer> getScores(){
        return scores;
    }
}