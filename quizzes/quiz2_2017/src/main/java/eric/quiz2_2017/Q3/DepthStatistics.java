package eric.quiz2_2017.Q3;

public class DepthStatistics {
    public static void main(String[] args) {

        int [] array = {53, 82, 49, 85, 50, 67, 54, 3, 80, 15, 86, 72, 22, 89, 55,
                28, 84, 16, 18, 9, 21, 2, 33, 76, 7, 65, 34, 97, 14, 12, 44, 47, 88,
                94, 45, 24, 95, 4, 43, 83, 8, 61, 25, 59, 73, 10, 98, 92, 91, 81};


        BSTDepthStatistics b = new BSTDepthStatistics();

        for (int i = 0; i < array.length; i++) {
             b.insert(array[i]);
        }

        System.out.println("\nInOrder Traversal: ");
        b.inOrder(b.root);

        int leafCount = b.countLeaves(b.root);
        int depthSum = b.sumOfLeafDepths(b.root,0);
        int depthMax = b.maximumLeafDepth(b.root,0);
        double averageDepth = ((double)depthSum) / leafCount;

        // Display the results.

        System.out.println("\nNumber of leaves:         " + leafCount);
        System.out.println("Average depth of leaves:  " + String.format("%.3f", averageDepth));
        System.out.println("Maximum depth of leaves:  " + depthMax);
    }

}


