package ArrayOfTrees;

public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
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

            // check if the string of newNode is equals to string of current
            // increment the occurrence of current node if equals and break out
            // see Node's equals method for more info
            if (data.equals(current.getData())) {
                current.increment();
                return;
            }

            // check if data's char ASCII is smaller than current's char ASCII
            // go into left child if smaller
            if (data.compareTo(current.getData()) > 0) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }

                // check if data's char ASCII is larger than current's char ASCII
                // go into right child if larger
            } else if (data.compareTo(current.getData()) > 0) {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }

        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(" " + root.getData() + " (" + root.getOccur() + ")");
            inOrder(root.getRight());
        }
    }
}
