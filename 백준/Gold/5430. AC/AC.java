import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) { // 100
            Deque<Integer> deque = new ArrayDeque<>();

            String command = br.readLine();
            int arrLength = Integer.parseInt(br.readLine());
            String arrInput = br.readLine();
            
            String[] arr = arrInput.substring(1, arrInput.length() - 1).split(",");

            for(int j = 0; j < arrLength; j++) { // 100
                deque.addLast(Integer.parseInt(arr[j]));
            }

            // 불필요한 반복을 최소화하기 위해 배열을 뒤집을지 말지 구분을 두는 reverse 변수 선언
            boolean reverse = true;
            boolean error = false;
            for(int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);

                // 뒤집는다는 의미인 R이 나오면 배열을 역방향으로 처리하기 위해 !reverse로 변경
                if(c == 'R') {
                    reverse = !reverse;
                } else {
                    if(deque.isEmpty()) { // deque가 비어있는데 제거 명령 시 오류 출력
                        error = true;

                        break;
                    } else {
                        // 조건 분기를 삼항연산자로 대체
                        int num = reverse ? deque.removeFirst() : deque.removeLast();
                    }
                }
            }
            if(error) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                if(!deque.isEmpty()) {
                    while(!deque.isEmpty()) {
                        if(reverse) {
                            sb.append(deque.removeFirst()).append(",");
                        } else {
                            sb.append(deque.removeLast()).append(",");
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("]").append("\n");
            }

        }
        System.out.println(sb);
    }
}