package Day26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UndirectedGraph {

    private static boolean helper(int edge, List<Set<Integer>> graph, boolean vis[], int parent) {
        vis[edge] = true;

        for (int nextEdge : graph.get(edge)) {
            if (!vis[nextEdge]) {
                if (helper(nextEdge, graph, vis, edge)) {
                    return true;
                }

            } else if (nextEdge != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(int V, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            graph.add(new HashSet<Integer>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            if (graph.get(src).contains(dst)) {
                return true;
            }
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                if (helper(i, graph, vis, -1)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(detectCycle(5, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 0 } }));
        System.out.println(detectCycle(3, new int[][] { { 0, 1 }, { 1, 2 } }));
        System.out.println(detectCycle(4, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }));
        System.out.println(detectCycle(2, new int[][] { { 0, 1 }, { 0, 1 } }));
        System.out.println(detectCycle(3, new int[][] {}));
        System.out.println(detectCycle(5, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 } }));
    }

}
