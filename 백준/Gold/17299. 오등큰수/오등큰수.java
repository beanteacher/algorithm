import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // 자신보다 등장한 횟수가 크면서 가장 왼쪽에 있을 값을 담을 stack
        Stack<Integer> stack = new Stack<>();
        int[] ngf = new int[n];
        for(int i = arr.length - 1; i >= 0; i--) {
            // arr[i]보다 stack에서 꺼낸 값이 등장 횟수가 더 큰 값이 나올 때까지 stack.pop()
            while(!stack.isEmpty() && map.get(arr[i]) >= map.get(stack.peek())) {
                stack.pop();
            }

            // stack이 비지 않았으면 arr[i]보다 등장 횟수가 큰 값 중 가장 왼쪽에 있는 값
            // 비어있으면 등장 횟수가 큰 값이 없으므로 -1 출력
            ngf[i] = !stack.isEmpty() ? stack.peek() : -1;

            // stack에 왼쪽에 있는 값 표현을 위해 arr[i] 추가
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(ngf[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}