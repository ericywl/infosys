package TernarySearchTree;

public class TernarySearchTree {
    Node root;

    public TernarySearchTree() {
        this.root = null;
    }

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent;

        while (true) {
            parent = current;

            if (id == current.data) {
                current = current.middle;
                if (current == null) {
                    parent.middle = newNode;
                    return;
                }

            } else {
                if (id <= current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }

                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean search(int x) {
        Node temp = root;

        while (true) {
            if (x < temp.data) {
                temp = temp.left;
                if (temp == null) {
                    return false;
                }

            } else if (x > temp.data) {
                temp = temp.right;
                if (temp == null) {
                    return false;
                }

            } else {
                return true;
            }
        }
    }

    public int findMin() {
        Node temp = root;

        while (true) {
            if (temp.left == null) {
                return temp.data;
            } else {
                temp = temp.left;
            }
        }
    }

    public int findMax() {
        Node temp = root;

        while (true) {
            if (temp.right == null) {
                return temp.data;
            } else {
                temp = temp.right;
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
            System.out.print(" " + root.data);
            inOrder(root.middle);
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


