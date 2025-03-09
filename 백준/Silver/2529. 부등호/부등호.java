import java.io.*;
import java.util.*;

public class Main {
    static String[] arr;
    static List<String> adjList = new ArrayList<>();
    static int n;
    static void dfs(int value, int index, String str, boolean[] visited) {
        if(index == n) { // index가 n인 시점 -> 문자열을 다 만들었을 때
            adjList.add(str);
        } else {
            visited[value] = true;

            if(arr[index++].equals("<")) { // '<'가 나온다면 현재 값보다 큰 값만 재귀
                for(int i = 9; i > value; i--) {
                    if(!visited[i]) {
                        dfs(i, index, str+i, visited.clone());
                    }
                }
            } else { // '>'가 나온다면 현재 값보다 작은 값만 재귀
                for(int i = 0; i < value; i++) {
                    if(!visited[i]) {
                        dfs(i, index, str + i, visited.clone());
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        for(int i = 0; i < 10; i++) {
            boolean[] visited = new boolean[10];
            dfs(i, 0, String.valueOf(i), visited); // 재귀 탐색 시작
        }

        Collections.sort(adjList); // 정렬

        System.out.println(adjList.get(adjList.size() - 1)); // 최댓값
        System.out.println(adjList.get(0)); // 최솟값
    }
}