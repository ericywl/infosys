package eric.quiz3_2015.Q6;


import java.util.ArrayList;
import java.util.List;

public class StronglyConnected {
    public static boolean isStronglyConnected(int nodeCount, int linkCount,
                                              ArrayList<Integer> listOfLink) {
        if (nodeCount > linkCount) return false;
        if (linkCount != listOfLink.size() / 2) return false;

        // initialize digraph
        Digraph g = new Digraph(nodeCount);
        for (int i = 0; i < listOfLink.size(); i += 2) {
            int start = listOfLink.get(i);
            int end = listOfLink.get(i + 1);
            g.adj[start].add(end);
        }

        g.DFS(0);
        // check that all vertices are visited in normal digraph
        for (boolean isVisited : g.getVisited()) {
            if (!isVisited) return false;
        }

        Digraph gRev = g.getTranspose();

        gRev.DFS(0);
        // check that all vertices are visited in reverse digraph
        for(boolean isVisited : g.getVisited()) {
            if (!isVisited) return false;
        }

        return true;
    }
}

class Digraph {
    List<Integer>[] adj;
    private boolean[] visited;
    private int numOfVertices;

    @SuppressWarnings("unchecked")
    Digraph(int nodeCount) {
        adj = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            adj[i] = new ArrayList<>();
        }

        visited = new boolean[nodeCount];
        this.numOfVertices = nodeCount;
    }

    // depth first search visit
    void DFS(int v) {
        visited[v] = true;
        for (Integer adjVertex : adj[v]) {
            if (!visited[adjVertex]) DFS(adjVertex);
        }
    }

    // reverse all edges
    Digraph getTranspose() {
        Digraph gRev = new Digraph(numOfVertices);

        for (int v = 0; v < numOfVertices; v++) {
            for (Integer adjVertex : adj[v]) {
                gRev.adj[adjVertex].add(v);
            }
        }

        return gRev;
    }

    boolean[] getVisited() {
        return visited;
    }
}
