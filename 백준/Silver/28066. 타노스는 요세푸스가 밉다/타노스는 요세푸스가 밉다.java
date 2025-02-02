import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < n + 1; i++) {
            queue.offer(i);
        }
        
        // 큐의 사이즈가 k보다 작아지면 첫 번째뺴고 다 없앨 예정이므로 종료
        while(queue.size() > k) {
            for(int i = 0; i < k; i++) {
                if(i == 0) {
                    queue.offer(queue.poll());
                } else {
                    queue.poll();
                }
            }
        }

        System.out.println(queue.poll());
    }
}