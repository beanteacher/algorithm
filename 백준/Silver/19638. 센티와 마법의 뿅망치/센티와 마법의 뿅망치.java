import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int centiHeight = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i = 0; i < n; i++) {
            heap.offer(Integer.parseInt(br.readLine()));
        }
        

				int hitCount = 0;
        for(int i = 0; i < t; i++) {
        
            // 거인이 centi보다 작거나 1이면 끝내기
            if((heap.peek() < centiHeight) || (heap.peek() == 1)) {
		            break;
            }
            
            heap.offer(heap.poll() / 2);
            hitCount++;
        }

        if(heap.peek() >= centiHeight) {
            System.out.println("NO");
            System.out.println(heap.peek());
        } else {
            System.out.println("YES");
            System.out.println(hitCount);
        }
    }
}