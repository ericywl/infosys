package Queue;

import java.util.ArrayList;
import java.util.List;

class EmptyQueueException extends Exception {
    public EmptyQueueException(String message) {
        super(message);
    }
}

class Node {
    private int data;
    private Node nextNode;

    public Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

public class Queue {
    private Node first;
    private Node last;
    private int size;

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(int data) {
        Node n = new Node(data, null);

        if (isEmpty()) {
            first = n;
        } else {
            last.setNextNode(n);
        }

        last = n;
        size++;
    }

    public Node dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }

        Node n = first;
        first = first.getNextNode();
        n.setNextNode(null);
        size--;
        return n;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }

        Node temp = first;
        while (temp != last.getNextNode()) {
            
        }

    }
}
