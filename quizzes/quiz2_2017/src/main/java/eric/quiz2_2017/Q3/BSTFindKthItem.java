package eric.quiz2_2017.Q3;

import java.util.Stack;

public class BSTFindKthItem {
    Node root;
    int countrange = 0;
    int counter = 0;

    public BSTFindKthItem() {
        this.root = null;
    }

    public void insert(char id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (id == current.data)
                return;

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

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data);
            inOrder(root.right);
        }
    }

    public void findKthItem(Node root, int k) {
        Stack<Node> stack = new Stack<>();

        Node curr = root;
        char result = 0;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node top = stack.pop();
                k--;

                if (k == 0)
                    result = top.data;
                curr = top.right;
            }
        }

        System.out.print(result);
    }

    public void getInRange(Node root, int l, int u) {
        if (u < l) {
            System.out.println("ERROR");
            return;
        }

        for (int i = l; i < u; i++) {
            findKthItem(root, i);
        }
    }

}

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
        left = null;
        right = null;
    }
}

