import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            heap.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(heap.size() >= 2) {
            int temp1 = heap.poll();
            int temp2 = heap.poll();

            result += temp1 + temp2;
            heap.offer(temp1 + temp2);
        }
        System.out.println(result);
    }
}