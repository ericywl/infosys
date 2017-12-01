package eric.quiz2_2017.Q3;

public class FindKthItem {
    public static void main(String[] args) {
        String S = "SUTD ISTD ASD ESD EPD";
        char[] c1 = S.toCharArray();

        BSTFindKthItem b = new BSTFindKthItem();

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == ' ') {
                // do nothing
            } else {
                b.insert(c1[i]);
            }
        }

        System.out.println("\nInOrder Traversal: ");
        b.inOrder(b.root);
        System.out.println ("\nFinding kth item: ");
        b.findKthItem(b.root, 7);

        System.out.println("\nGet in Range: ");
        b.getInRange(b.root, 4, 8);
    }
}


