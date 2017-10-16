package BinarySearchTree;

public class BSTMain {
    public static void main(String[] args) {
        // String S = "the quick brown fox jumps over the lazy dog";
        // String S = "SUTD ISTD ASD ESD EPD";

        int[] num = {100, 200, 590, 70, 80, 360, 110};

        BinarySearchTree b = new BinarySearchTree();

        for (int i : num) {
            b.insert(i);
        }

        System.out.println("\nPreOrder Traversal: ");
        b.preOrder(b.root);
        System.out.println("\nInOrder Traversal: ");
        b.inOrder(b.root);
        System.out.println("\nPostOrder Traversal: ");
        b.postOrder(b.root);
    }

    public static void compressInput(int[] num1, int[] num2) {
        int p = 0;
        for (int i : num1) {
            num2[p] = i;
            p++;
        }
    }
}

