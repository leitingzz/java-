package Linked_List;

public class MyQueue {
    private Node head;
    private Node tail;

    public MyQueue(){
        head = null;
        tail = null;
    }

    public void enqueue(int data){
        Node newnNode = new Node(data,null);
        if(head == null){
            head = newnNode;
            tail = newnNode;
        }else{
            tail.next = newnNode;
            tail = newnNode;
        }
    }

    public int dequeue(){
        if(head == null){
            System.out.println("队列为空！");
            return -1;
        }
        if(head.next == null){
            tail = null;
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    public boolean isEmpty(){
        return head == null;
    }
}