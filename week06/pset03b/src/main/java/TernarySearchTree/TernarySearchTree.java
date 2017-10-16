package TernarySearchTree;

public class TernarySearchTree {
    Node root;

    public TernarySearchTree() {
        this.root = null;
    }

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            insert(root, val);
        }
    }

    private void insert(Node root, int val) {
        Node n = new Node(val);

        if (val < root.data) {
            if (root.left == null) {
                root.left = n;
            } else {
                insert(root.left, val);
            }
        } else if (val > root.data) {
            if (root.right == null) {
                root.right = n;
            } else {
                insert(root.right, val);
            }
        } else {
            if (root.middle == null) {
                root.middle = n;
            } else {
                insert(root.middle, val);
            }
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(" " + root.data);
            preOrder(root.left);
            preOrder(root.middle);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            inOrder(root.middle);
            System.out.print(" " + root.data);
            inOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.middle);
            postOrder(root.right);
            System.out.print(" " + root.data);
        }
    }

}

class Node {
    int data;
    Node left;
    Node right;
    Node middle;

    public Node(int data) {
        this.data = data;
        left = null;
        middle = null;
        right = null;
    }
}


