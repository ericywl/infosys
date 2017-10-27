package TernarySearchTree;

public class TernarySearchTree {
    Node root;

    public TernarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent;

        while (true) {
            parent = current;

            if (current.val2 == -1) {
                current.nodeInsert(data);
                return;
            }

            if (data > current.val1 && data < current.val2) {
                current = current.middle;
                if (current == null) {
                    parent.middle = newNode;
                    return;
                }

            } else if (data < current.val1) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }

            } else if (data > current.val2) {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public int search(Node root, int x, int depthOfRoot) {
        Node temp = root;
        int depth = 0;

        while (temp != null) {
            if (x == temp.val1 || x == temp.val2) {
                return depth;
            }

            if (x < temp.val1) {
                temp = temp.left;
                depth++;
                if (temp == null) return -1;

            } else if (x > temp.val1 && x < temp.val2) {
                temp = temp.middle;
                depth++;
                if (temp == null) return -1;

            } else if (x > temp.val2) {
                temp = temp.right;
                depth++;
                if (temp == null) return -1;
            }
        }

        return depth;
    }

    public int findMin(Node root) {
        Node temp = root;

        while (true) {
            if (temp.left == null) {
                return temp.val1;
            } else {
                temp = temp.left;
            }
        }
    }

    public int findMax(Node root) {
        Node temp = root;

        while (true) {
            if (temp.right == null) {
                return temp.val2;
            } else {
                temp = temp.right;
            }
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(" " + root.val1 + " " + root.val2 + " :");
            preOrder(root.left);
            preOrder(root.middle);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(" " + root.val1 + " :");
            inOrder(root.middle);
            System.out.print(" " + root.val2 + " :");
            inOrder(root.right);

        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.middle);
            postOrder(root.right);
            System.out.print(" " + root.val1 + " " + root.val2 + " :");
        }
    }

}

class Node {
    int val1;
    int val2 = -1;
    Node left;
    Node right;
    Node middle;

    public Node(int data) {
        val1 = data;
        left = null;
        middle = null;
        right = null;
    }

    public void nodeInsert(int data) {
        if (data > this.val1) {
            this.val2 = data;
            return;
        }

        if (data < this.val1) {
            this.val2 = this.val1;
            this.val1 = data;
        }
    }
}


