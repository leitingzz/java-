package Linked_List;

public class MyStack {
    private Node top;

    public MyStack(){
        top = null;
    }

    public void push(int data){
        Node newNode = new Node(data, top);
        top = newNode;
    }

    public int pop(){
        if(top == null){
            System.out.println("栈为空！");
            return -1;
        }

        int value = top.data;
        top = top.next;
        return value;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
}