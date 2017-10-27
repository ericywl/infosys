package Stack;

import java.util.Scanner;

class EmptyStackException extends Exception {
    public EmptyStackException(String message) {
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

public class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    public void push(int data) {
        Node n = new Node(data, null);

        if (top != null) {
            n.setNextNode(top);
        }

        top = n;
    }

    public Node pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty.");
        }

        Node n = top;
        top = top.getNextNode();
        n.setNextNode(null);
        return n;
    }

    public int peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty.");
        }

        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty.");
        }

        Node temp = top;
        StringBuilder outputBuilder = new StringBuilder();

        while (temp != null) {
            outputBuilder.append(temp.getData());
            outputBuilder.append(" -> ");
            temp = temp.getNextNode();
        }

        String output = outputBuilder.toString();
        int outputLength = output.length();
        System.out.println(output.substring(0, outputLength - 4));
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Stack stack = new Stack();
        char ch;
        System.out.println("Stack Test");

        do {
            System.out.println("\nStack Operations\n");
            System.out.println("1. Push");
            System.out.println("2. Top");
            System.out.println("3. Pop");
            System.out.println("4. isEmpty");
            System.out.println("5. displayStack");

            System.out.print("Enter the operation code: ");
            String choice = reader.next();

            switch(choice) {
                case "1":
                    System.out.print("Enter integer element to push: ");
                    int data = reader.nextInt();
                    stack.push(data);
                    try {
                        System.out.print("Stack = ");
                        stack.display();
                    } catch (EmptyStackException ex) {
                        System.out.println(ex);
                    }
                    break;

                case "2":
                    System.out.println("Peeking top element...");
                    try {
                        System.out.println("Element: " + stack.peek());
                    } catch (EmptyStackException ex) {
                        System.out.println(ex);
                    }
                    break;

                case "3":
                    System.out.println("Popping top element...");
                    try {
                        System.out.println("Element popped: " + stack.pop().getData());
                        System.out.print("Stack = ");
                        stack.display();
                    } catch (EmptyStackException ex) {
                        System.out.println(ex);
                    }
                    break;

                case "4":
                    System.out.print("Checking if stack is empty: ");
                    System.out.println(stack.isEmpty());
                    break;

                case "5":
                    System.out.println("Displaying stack...");
                    try {
                        stack.display();
                    } catch (EmptyStackException ex) {
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
