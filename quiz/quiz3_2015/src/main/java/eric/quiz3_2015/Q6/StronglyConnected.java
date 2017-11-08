package eric.quiz3_2015.Q6;


import java.util.ArrayList;
import java.util.List;

public class StronglyConnected {
    public static boolean isStronglyConnected(int nodeCount, int linkCount,
                                              ArrayList<Integer> listOfLink) {
        if (nodeCount > linkCount) return false;
        if (linkCount != listOfLink.size()) return false;

        Digraph g = new Digraph(nodeCount);
        for (int i = 0; i < listOfLink.size(); i += 2) {
            if (g.adj[i] == null)
                g.adj[i] = new ArrayList<>();

            g.adj[i].add(i + 1);
        }

        return false;
    }

    private static int DFS() {
        return 0;
    }
}

class Digraph {
    List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    Digraph(int numOfVertices) {
        adj = new ArrayList[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }
}
