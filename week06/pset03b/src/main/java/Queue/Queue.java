package Queue;

import java.util.Scanner;

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

    public Queue() {
        first = null;
        last = null;
    }

    public void enqueue(int data) {
        Node n = new Node(data, null);

        if (isEmpty()) {
            first = n;
        } else {
            last.setNextNode(n);
        }

        last = n;
    }

    public Node dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        }

        Node n = first;
        first = first.getNextNode();
        n.setNextNode(null);
        return n;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void display() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        }

        Node temp = first;
        String tempStr;
        StringBuilder outputBuilder = new StringBuilder();

        while (temp != null) {
            tempStr = " -> " + temp.getData();
            StringBuilder tempStrBuilder = new StringBuilder();
            tempStrBuilder.append(tempStr);
            outputBuilder.append(tempStrBuilder.reverse().toString());
            temp = temp.getNextNode();
        }

        String output = outputBuilder.reverse().toString();
        int outputLength = output.length();
        System.out.println(output.substring(4, outputLength));
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Queue queue = new Queue();
        char ch;
        System.out.println("Queue Test");

        do {
            System.out.println("\nQueue Operations\n");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. isEmpty");
            System.out.println("4. displayQueue");

            System.out.print("Enter the operation code: ");
            String choice = reader.next();

            switch(choice) {
                case "1":
                    System.out.print("Enter integer element to queue: ");
                    int data = reader.nextInt();
                    queue.enqueue(data);
                    try {
                        System.out.print("Queue = ");
                        queue.display();
                    } catch (EmptyQueueException ex) {
                        System.out.println(ex);
                    }
                    break;

                case "2":
                    System.out.println("Dequeuing...");
                    try {
                        System.out.println("Item dequeued: " + queue.dequeue().getData());
                        System.out.print("Queue = ");
                        queue.display();
                    } catch (EmptyQueueException ex) {
                        System.out.println(ex);
                    }
                    break;

                case "3":
                    System.out.println("Checking if queue is empty...");
                    System.out.println(queue.isEmpty());
                    break;

                case "4":
                    System.out.println("Displaying queue...");
                    try {
                        queue.display();
                    } catch (EmptyQueueException ex) {
                        System.out.println(ex);
                    }
                    break;

                default:
                    System.out.println("That is not a valid operation.");
                    break;
            }

            System.out.print("\nDo you wish to continue (Type y or n): ");
            ch = reader.next().charAt(0);
        } while(ch == 'y' || ch == 'Y');
    }
}
