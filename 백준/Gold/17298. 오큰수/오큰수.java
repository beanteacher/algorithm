import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] ngeArr = new int[n]; // 결과 배열
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열의 뒤쪽부터 처리
        for (int i = n - 1; i >= 0; i--) {
            // 스택의 맨 위 값이 현재 값보다 작거나 같으면 제거
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // 스택이 비어 있으면 NGE가 없으므로 -1, 그렇지 않으면 스택의 맨 위 값이 NGE
            ngeArr[i] = stack.isEmpty() ? -1 : stack.peek();

            // 현재 값을 스택에 추가
            stack.push(arr[i]);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : ngeArr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}