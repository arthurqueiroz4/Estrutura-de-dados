package tad.LinkedList;

public class LinkedList {
    private Node head;
    private int lenght;

    public void insertAtBeginning(Object data){
        var newNode = new Node();
        newNode.setData(data);
        if (this.getLenght() == 0){
            this.setHead(newNode);
        } else {
            newNode.setNext(this.getHead());
            this.setHead(newNode);
        }
        this.setLenght(this.getLenght() + 1);
    }

    public void insertAtGivenPosition(int pos, Object data) throws Exception {
        if (pos > this.getLenght() || pos < 0){
            throw new Exception("Posição inválida.");
        }
        if (pos == 0)
            this.insertAtBeginning(data);
        else if (pos == this.getLenght())
            this.insertAtEnd(data);
        else {
            var newNode = new Node();
            newNode.setData(data);
            var count = 1;
            var current = this.getHead();
            while (count < pos-1){
                count++;
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            this.setLenght(this.getLenght() + 1);
        }
    }


    public void insertAtEnd(Object data){
        var newNode = new Node();
        newNode.setData(data);
        if (this.getLenght() == 0){
            this.setHead(newNode);
            this.setLenght(this.getLenght() + 1);
        } else {
            var lastNode = getLastNode();
            lastNode.setNext(newNode);
            this.setLenght(this.getLenght()+1);
        }
    }

    public Node getLastNode(){
        var current = this.getHead();
        while (current.hasNext()) {
            current = current.getNext();
        }
        return current;
    }

    public void deleteFromBeginning(){
        if (!this.isEmpty()){
            this.head = head.getNext();
            this.lenght--;
        }
    }

    public void deleteFromEnd(){
        if (!this.isEmpty()){
            var current = this.head;
            while (current.getNext().hasNext())
                current = current.getNext();
            current.setNext(null);
        }
    }

    public void deleteAtPosition(int pos){
        if (pos >= this.lenght)
            throw new RuntimeException("Posição fora do alcance.");
        if (!this.isEmpty()){
            int count=0;
            var current = this.head;
            Node previous = new Node();

            while (count != pos+1){
                if (count == pos-1){
                    previous = current;
                }
                current = current.getNext();
                count++;
            }

            previous.setNext(current);
        }
    }


    public void printLinkedList(){
        if (this.getLenght() == 0)
            System.out.println(this.head);
        else {
            var current = this.head;
            while (current != null){
                System.out.println(current.getData());
                current = current.getNext();
            }
        }
    }

    private boolean isEmpty(){
        return this.getLenght() == 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
