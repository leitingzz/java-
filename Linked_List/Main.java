package Linked_List;

public class Main {
    public static void main(String[] args){
        Node head = null;
        linkedList newList = new linkedList(head);
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.printList();
    }
}
