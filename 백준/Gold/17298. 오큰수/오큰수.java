import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 자신의 값보다 크면서 가장 왼쪽에 있을 값을 담을 stack
        Stack<Integer> stack = new Stack<>();
        int[] resultArr = new int[n];
        for(int i = arr.length-1; i >= 0; i--) {
            // arr[i]보다 stack에서 큰 값이 나올 때까지 stack.pop()
            while(!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            // stack이 비지 않았으면 arr[i]보다 큰 값 중 가장 왼쪽에 있는 값이 들어있으므로 해당 값 출력
            if(!stack.isEmpty()) {
                resultArr[i] = stack.peek();
            } else { // stack이 비었다면 arr[i]보다 큰 값이 없으므로 -1 출력
                resultArr[i] = -1;
            }
            // stack에 다음 순서의 왼쪽에 있는 값 표현을 위해 arr[i] 추가
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(resultArr[i]).append(" ");
        }

        System.out.println(sb);
    }
}