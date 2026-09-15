public class ArrayAndForLoop {
    public static void main(String[] args){
        int[] nums = new int[10];
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            nums[i] = i + 1;
            total += i + 1;
        }
        double average = (double)total / 10;
        System.out.println("总和为：" + total);
        System.out.println("平均数为：" + average);
        String[] names = {"张三", "李四", "王五"};
        for(String name: names){
            System.out.println(name);
        }
    }
}
