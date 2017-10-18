package ArrayOfTrees;

public class ArrayOfTrees {
    private BST[] treeArray;
    private final int length = 26;
    private static final String INPUT_EX1 = "This is a piece of text from which hopefully you will" +
            " make some trees.";
    private static final String INPUT_EX2 = "I want to go to some faraway land where no one can find me.";

    public ArrayOfTrees() {
        this.treeArray = new BST[26];
    }

    public void put(String input) {
        String[] inputArray = input.trim().split("\\s+");

        // insert each word into treeArray
        for (String s : inputArray) {
            char firstLetter = s.toUpperCase().charAt(0);
            if (treeArray[firstLetter - 'A'] == null) {
                treeArray[firstLetter - 'A'] = new BST();
            }

            treeArray[firstLetter - 'A'].insert(s);
        }

        // inorder traversal for all trees
        for (BST tree : treeArray) {
            if (tree != null) {
                System.out.print("Inorder Traversal:");
                tree.inOrder(tree.getRoot());
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        ArrayOfTrees arrayOfTrees = new ArrayOfTrees();
        arrayOfTrees.put(INPUT_EX1);
    }
}
