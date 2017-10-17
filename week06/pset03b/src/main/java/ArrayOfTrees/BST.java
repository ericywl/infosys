package ArrayOfTrees;

public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    public void insert(String data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent;

        while (true) {
            parent = current;

            if (newNode.equals(current)) {
                current.increment();
                return;
            }

        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(" " + root.getData());
            inOrder(root.getRight());
        }
    }
}
