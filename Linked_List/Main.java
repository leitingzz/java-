package Linked_List;

public class Main {
    public static void main(String[] args){
        MyQueue newQueue = new MyQueue();
        newQueue.enqueue(1);
        newQueue.enqueue(2);
        newQueue.enqueue(3);
        System.out.println(newQueue.dequeue());
        System.out.println(newQueue.dequeue());
        System.out.println(newQueue.dequeue());
        System.out.println(newQueue.dequeue());
    }
}