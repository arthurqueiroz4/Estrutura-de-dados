package tad.LinkedListProblem;

import tad.LinkedList.Node;

import tad.LinkedList.LinkedList;

public class Problems extends LinkedList {

    public static void main(String[] args) {
        var problem = new Problems();
        for (int i = 0; i <= 3; i++) {
            problem.insertAtEnd(i);
        }
        problem.insertAtEnd(5);

        problem.printLinkedList();
        problem.insertByOrder(6);
        problem.insertByOrder(4);
        problem.insertByOrder(-1);
        problem.printLinkedList();
    }

    public Node printLastN(int index) {
        Node fast = this.getHead();
        Node slow = this.getHead();
        int count = 0;

        while (fast.hasNext() && (count != index)) {
            count++;
            fast = fast.getNext();
        }

        while (fast.hasNext()) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }

    public int printLastToFirst(Node head) {
        if (head == null)
            return 0;
        printLastToFirst(head.getNext());
        System.out.println(head.getData());
        return 1;
    }

    public int insertByOrder(int data) {
        Node previous = this.getHead();
        Node current = this.getHead().getNext();
        Node newNode = new Node(data, null);

        if (((int) previous.getData()) > data) {
            this.insertAtBeginning(data);
            return 0;
        }

        while (current.getNext() != null ) {
            if ( ((int) current.getData()) > data) {
                break;
            }
            current = current.getNext();
            previous = previous.getNext();
        }

        if (( (int) current.getData()) < data){
            current.setNext(newNode);
        } else {
            previous.setNext(newNode);
            newNode.setNext(current);
        }
        return 1;
    }
}
