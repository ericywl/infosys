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

    @Override
    public boolean equals(Object o) {
        // check if object is null or if object's class is not the same
        if (o == null) {
            return false;
        }

        if (o.getClass() != getClass()) {
            return false;
        }

        Node compared = (Node) o;

        // check if their data are not equal or if this.data is null
        if (!getData().equals(compared.getData()) || this.getData() == null) {
            return false;
        }

        return true;
    }
}
