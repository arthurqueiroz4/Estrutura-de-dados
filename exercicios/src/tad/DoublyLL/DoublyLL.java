package tad.DoublyLL;

public class DoublyLL {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLL(Node head, Node tail, int length) {
        this.head = head;
        this.tail = tail;
        this.length = length;
    }
    public DoublyLL(){

    }

    private void setHeadAndTail(Object data){
        Node node = new Node(data, null, null);
        this.head = node;
        this.tail = node;
        this.incrementLength();
    }

    public void insertAtBeginning(Object data){
        if (this.getLength() == 0) {
            this.setHeadAndTail(data);
        }else {
            Node newNode = new Node(data, null, this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
            this.incrementLength();
        }
    }

    public void insertAtEnd(Object data){
        if (this.getLength() == 0){
            this.setHeadAndTail(data);
        } else {
            Node newNode = new Node(data, this.tail, null);
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.incrementLength();
        }
    }

    public void insertAtMiddle(Object data, int pos){
        if (pos >= this.getLength() || pos < 0)
            throw new RuntimeException("Position out range");
        else if (pos == this.length-1)
            this.insertAtEnd(data);
        else if (pos == 0) {
            this.insertAtBeginning(data);
        }
        else {
            Node newNode = new Node(data, null, null);
            Node nodeAtIndex = this.getByIndex(pos);

            nodeAtIndex.getPrevious().setNext(newNode);

            newNode.setPrevious(nodeAtIndex.getPrevious());
            newNode.setNext(nodeAtIndex);

            nodeAtIndex.setPrevious(newNode);
            this.incrementLength();
        }

    }

    public void deleteAtIndex(int index){
        if (index == 0){
            this.deleteAtBeginning();
        } else if (index == this.getLength() - 1){
            this.deleteAtEnd();
        } else {
            Node current = this.getByIndex(index);
            Node previous = current.getPrevious();
            Node next = current.getNext();

            previous.setNext(next);
            next.setPrevious(previous);
        }
    }

    private void deleteAtEnd() {
        Node newTail = this.tail.getPrevious();
        newTail.setNext(null);
        this.tail = newTail;
    }

    private void deleteAtBeginning() {
        Node newHead = this.head.getNext();
        newHead.setPrevious(null);
        this.head = newHead;
    }

    private Node getByIndex(int index){
        if (this.length == 0)
            throw new RuntimeException("List empty");
        else if (index == 0){
            return this.head;
        } else if (index == this.getLength() - 1)
            return this.tail;
        else {
            Node current = this.head;
            int count=0;
            while (count != index) {
                current = current.getNext();
                count++;
            }
            return current;
        }
    }

    public void print(){
        Node current = this.head;
        int index=0;
        while (current != null){
            System.out.println(index +" - "+current+"{" +
                    "data=" + current.getData() +
                    ", previous=" + current.getPrevious() +
                    ", next=" + current.getNext() +
                    '}');
            current = current.getNext();
            index++;
        }

    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    private void incrementLength(){
        ++this.length;
    }

    private void decrementLength(){
        --this.length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
