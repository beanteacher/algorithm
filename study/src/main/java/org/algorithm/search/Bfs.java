package org.algorithm.search;

import java.util.*;

public class Bfs {
    static Map<Integer, List<Integer>> graph = new HashMap<>(); // 그래프를 인접 리스트로 표현
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        graph.put(1, Arrays.asList(2,3));
        graph.put(2, Arrays.asList(4,5));
        graph.put(3, Arrays.asList(6,7));
        graph.put(4, Collections.emptyList());
        graph.put(5, Collections.emptyList());
        graph.put(6, Collections.emptyList());
        graph.put(7, Collections.emptyList());

        bfs(1);
        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()+1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for(int neighbor : neighbors) {
                if(!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
