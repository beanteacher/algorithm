import java.util.*;
import java.io.*;
public class Main {
    //7 3
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int repeat = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < repeat; i++) {
            queue.offer(i+1);
        }

        String result = "";

        for(int i = 0; i < repeat; i++) {
            for(int j = 0; j < num; j++) {
                if(j == num - 1) {
                    if(i == repeat - 1) {
                        result += queue.poll();    
                    } else {
                        result += queue.poll() + ", ";
                    }
                    
                } else {
                    queue.offer(queue.poll());
                }
            }
        }

        System.out.println("<" + result + ">");
    }
}