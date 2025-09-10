package Day27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {
    public static int findShortestPath(int V, int src, int dst, int[][] edges) {
        if (src == dst) {
            return 0;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            graph.get(s).add(d);
            graph.get(d).add(s);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        int dis[] = new int[V];
        Arrays.fill(dis, -1);
        dis[src] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nextNode : graph.get(curr)) {
                if (dis[nextNode] != -1) {
                    continue;
                }
                dis[nextNode] = dis[curr] + 1;
                if (dst == nextNode) {
                    return dis[nextNode];
                }
                q.offer(nextNode);
            }
        }

        return dis[dst];
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] Edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 3, 4 } };
        int start = 0, end = 4;

        int path = findShortestPath(V, start, end, Edges);
        System.out.println("Shortest path is : " + path);

    }

}
