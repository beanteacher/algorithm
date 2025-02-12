import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> stack = new Stack<>();

        int i = 1;

        while(true) {
            if(!queue.isEmpty() && queue.peek() == i) {
                queue.poll();
                i++;
            } else if(!stack.isEmpty() && stack.peek() == i){
                stack.pop();
                i++;
            } else if(!queue.isEmpty()){
                stack.push(queue.poll());
            } else {
                break;
            }
        }

        if(i == n + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}