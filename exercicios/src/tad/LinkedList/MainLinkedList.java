package tad.LinkedList;

public class MainLinkedList {
    public static void main(String[] args) {
        var linkedList = new LinkedList();
        linkedList.insertAtBeginning("Insertando");
        linkedList.insertAtBeginning(123);
        linkedList.insertAtBeginning(true);
        linkedList.insertAtEnd("no Final");

        linkedList.printLinkedList();
        linkedList.deleteAtPosition(4);
        System.out.println();
        linkedList.printLinkedList();



    }
}

