import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args){
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("苹果");
        fruits.add("香蕉");
        fruits.add("梨");
        fruits.add("西瓜");
        fruits.add("桃子");
        fruits.remove("苹果");
        fruits.contains("西瓜");
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }
}
