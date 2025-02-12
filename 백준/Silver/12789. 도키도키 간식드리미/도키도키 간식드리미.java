import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 승환이 앞의 N명의 학생을 저장할 Queue 선언
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        // 한 명씩만 설 수 있는 줄을 세우기 위한 후입선출의 Stack 선언
        Stack<Integer> stack = new Stack<>();
        int i = 1;

        while(true) {
            // queue의 맨 앞에서 빼온 값이 i와 같으면 간식 받을 순서가 됐으므로 간식을 받고 번호표를 하나 올려준다.
            if(!queue.isEmpty() && queue.peek() == i) {
                queue.poll();
                i++;
            } else if(!stack.isEmpty() && stack.peek() == i){ // stack에 마지막에 들어간 값이 i와 같으면 간식 받을 순서가 됐으므로 간식을 받고 번호표를 하나 올려준다.
                stack.pop();
                i++;
            } else if(!queue.isEmpty()){ // queue가 비어있지 않은데 자기 자신의 차례가 아니라면 새로운 줄을 설 수 있게끔 stack에 추가
                stack.push(queue.poll());
            } else { // 더 이상 queue에서 꺼낼 데이터가 존재하지 않다면 break;
                break;
            }
        }

        // i가 n+1이 되었다는 의미는 모두 간식을 받았다는 의미
        if(i == n + 1) {
            System.out.println("Nice");
        } else { // queue도 다 꺼내서 stack에서 꺼낼 차롄데 자기 자신의 차례가 오지 않아 간식을 받지 못한 경우
            System.out.println("Sad");
        }
    }
}