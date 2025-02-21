import java.util.*;
import java.io.*;

public class Main {
    static class Tower {
        int height;
        int index;

        public Tower(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> towerStack = new Stack<>();

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            // 현재 타워보다 왼쪽에 높은 타워가 있을 때까지 낮은 타워를 stack에서 지운다.
            while(!towerStack.isEmpty() && arr[i] > towerStack.peek().height) {
                towerStack.pop();
            }

            // 높은 타워가 있다면 인덱스를 출력 그렇지 않다면 0 출력
            result[i] = !towerStack.isEmpty() ? towerStack.peek().index : 0;

            // 왼쪽에 타워가 있다를 체크하기 위해 stack에 타워 추가
            towerStack.push(new Tower(arr[i], i + 1));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}