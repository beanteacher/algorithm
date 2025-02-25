package org.algorithm.search;

import java.util.*;

public class DfsStack {
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

    static void dfs(int currentNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(currentNode);
        visited[currentNode] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            sb.append(node).append(" ");

            // 인접 노드를 스택에 추가 (방문하지 않는 노드만 추가)
            for(int neighbor : graph[node]) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true; // 인접 노드를 방문했다고 표시
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
        System.out.println(sb);
    }
}
