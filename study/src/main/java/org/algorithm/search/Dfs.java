package org.algorithm.search;

public class Dfs {

    static int[][] graph = {
            {}, // 0번 노드는 사용하지 않는다.
            {2,3}, // 1번 노드와 연결된 노드들
            {1,4}, // 2번 노드와 연결된 노드들
            {1,4,5}, // 3번 노드와 연결된 노드들
            {2,3,5}, // 4번 노드와 연결된 노드들
            {3,4} // 5번 노드와 연결된 노드들
    };
    static boolean[] visited = new boolean[graph.length];
    static StringBuilder sb = new StringBuilder();

    static void dfs(int node) {
        visited[node] = true; // 현재 노드를 방문한 것으로 표시
        sb.append(node).append(" ");

        // 현재 노드의 인접 노드를 재귀적으로 방문
        for(int neighbor : graph[node]) {
            if(!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
        System.out.println(sb);
    }
}
