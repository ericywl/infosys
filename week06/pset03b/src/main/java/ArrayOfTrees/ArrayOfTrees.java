package ArrayOfTrees;

import java.util.Arrays;

public class ArrayOfTrees {
    private BST[] treeArray;
    private final int length = 26;
    private static final String INPUT_EX = "This is a piece of text from which hopefully you will" +
            "make some trees.";

    public ArrayOfTrees() {
        this.treeArray = new BST[26];
    }

    public void put(String s) {
        char firstLetter = s.toUpperCase().charAt(0);
        BST tree = treeArray[firstLetter - 'A'];
    }

    public static void arrayTrees(String input) {
        ArrayOfTrees arrayOfTrees = new ArrayOfTrees();
        String[] inputArray = input.trim().split("\\s+");

        for (String s : inputArray) {
            arrayOfTrees.put(s);
        }
    }

    public static void main(String[] args) {

    }
}
