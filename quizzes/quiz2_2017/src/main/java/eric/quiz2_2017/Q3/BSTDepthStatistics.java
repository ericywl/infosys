package eric.quiz2_2017.Q3;

public class BSTDepthStatistics {
    BSTNode root;

    public BSTDepthStatistics() {
        this.root = null;
    }

    public void insert(int id) {
        BSTNode newNode = new BSTNode(id);
        if (root == null) {
            root = newNode;
            return;
        }

        BSTNode current = root;
        BSTNode parent = null;
        while (true) {
            parent = current;
            if (id == current.data) {
                return;
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

    public void preOrder(BSTNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(BSTNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(" " + root.data);
            inOrder(root.right);
        }
    }

    public void postOrder(BSTNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(" " + root.data);
        }
    }

    static int countLeaves(BSTNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null)
            return 1;

        return countLeaves(node.left) + countLeaves(node.right);
    }


    static int sumOfLeafDepths(BSTNode node, int depth) {
        if (node == null) return 0;
        if (node.left == null && node.right == null)
            return depth;

        return sumOfLeafDepths(node.left, depth + 1) +
                sumOfLeafDepths(node.right, depth + 1);
    }

    static int maximumLeafDepth(BSTNode node, int depth) {
        if (node == null) return 0;
        if (node.left == null && node.right == null)
            return depth;

        int leftMax = maximumLeafDepth(node.left, depth + 1);
        int rightMax = maximumLeafDepth(node.right, depth + 1);
        return Math.max(leftMax, rightMax);
    }

    class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;


        public BSTNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
