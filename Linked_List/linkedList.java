package Linked_List;

public class linkedList {

    private Node head;
    
    public linkedList(Node head){
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
}