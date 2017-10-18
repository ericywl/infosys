package TernarySearchTree;

public class TSTMain {
    public static void main(String[] args) {
        // String S = "the quick brown fox jumps over the lazy dog";
        // String S = "SUTD ISTD ASD ESD EPD";

        int[] num = {100, 200, 590, 70, 80, 360, 110, 105, 102, 107};

        TernarySearchTree t = new TernarySearchTree();

        for (int i : num) {
            t.insert(i);
        }

        System.out.println("\nPreOrder Traversal: ");
        t.preOrder(t.root);
        System.out.println("\nInOrder Traversal: ");
        t.inOrder(t.root);
        System.out.println("\nPostOrder Traversal: ");
        t.postOrder(t.root);

        System.out.println("\n");
        System.out.println(t.search(100));
        System.out.println(t.search(590));

        System.out.println("");
        System.out.println(t.findMin());
        System.out.println(t.findMax());
    }
}


