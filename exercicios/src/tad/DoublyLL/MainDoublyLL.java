package tad.DoublyLL;

public class MainDoublyLL {
    public static void main(String[] args) {
        DoublyLL doublyLL = new DoublyLL();
        doublyLL.insertAtBeginning("fim");
        doublyLL.insertAtBeginning("inicio");
        doublyLL.insertAtEnd("final mesmo");
        doublyLL.insertAtMiddle("no meio", 0);
        doublyLL.insertAtMiddle("no meio1", 2);
        doublyLL.print();
        System.out.println("--------------------------------------------");
        doublyLL.deleteAtIndex(0);
        doublyLL.deleteAtIndex(doublyLL.getLength()-1);
        doublyLL.deleteAtIndex(1);
        doublyLL.print();
    }
}
