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

        for(int i = 0; i < t; i++) {
            // centi보다 작아지면 끝내기
            if(heap.peek() < centiHeight) {
                System.out.println("YES");
                System.out.println(i);
                
                return;
            }
            // MaxHeap에서 가장 큰 값이 1이 아니면 때린다.
            if(heap.peek() == 1) {
                t = i;
                break;
            } else {
                heap.offer(heap.poll() / 2);
            }
        }

        if(heap.peek() >= centiHeight) {
            System.out.println("NO");
            System.out.println(heap.poll());
        } else {
            System.out.println("YES");
            System.out.println(t);
        }
    }
}