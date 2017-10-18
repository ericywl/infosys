package ArrayOfTrees;

class Node {
    private String data;
    private int occurrence;
    private Node left;
    private Node right;
    private Node middle;

    public Node(String data) {
        this.data = data;
        this.occurrence = 1;
        left = null;
        right = null;
        middle = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getMiddle() {
        return middle;
    }

    public void setMiddle(Node middle) {
        this.middle = middle;
    }

    public int getOccur() {
        return occurrence;
    }

    public void increment() {
        this.occurrence++;
    }
}
