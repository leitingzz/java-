package Linked_List;

public class linkedList {

    private Node head;
    
    public linkedList(){
        head = null;
    }

    public void add(int data){
        Node newNode = new Node(data, null);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void printList(){
        Node current = head;
        while (current != null) {
            System.out.println(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void delete(int data){
        if(head == null){
            System.out.println("链表为空！");
            return ;
        }
        Node curr = head;
        Node prev = curr;
        while(curr != null && curr.data != data){
            prev = curr;
            curr = curr.next;
        }
        if(curr == null){
            System.out.println("该数据不存在！");
            return ;
        }
        if(curr == head){
            head = head.next;
        }else{
            prev.next = curr.next;
        }
    }
}