package tad.DoublyLL;

public class MainDoublyLL {
    public static void main(String[] args) {
        DoublyLL doublyLL = new DoublyLL();
        doublyLL.insertAtBeginning("fim");
        doublyLL.insertAtBeginning("inicio");
        doublyLL.insertAtEnd("final mesmo");
        doublyLL.print();

        doublyLL.insertAtMiddle("no meio", 0);
        doublyLL.insertAtMiddle("no meio1", 2);
        doublyLL.print();
    }
}
