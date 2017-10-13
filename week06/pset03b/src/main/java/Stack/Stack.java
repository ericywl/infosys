package Stack;

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
    private int size;

    public Stack() {
        top = null;
        size = 0;
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
            throw new EmptyStackException("Stack is empty");
        }

        Node n = top;
        top = top.getNextNode();
        n.setNextNode(null);
        return n;
    }

    public Node peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }

        return top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }

        Node temp = top;

        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNextNode();
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        try {
            stack.push(2);
            stack.push(5);
            stack.push(20);
            stack.display();

            Node n = stack.pop();
            System.out.println(n.getData());
            System.out.println(n.getNextNode() + "\n");
            System.out.println(stack.peek().getData());
        } catch (EmptyStackException ex) {
            System.out.println(ex);
        }
    }
}
