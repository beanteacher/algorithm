import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> heap = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            heap.offer(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while(heap.size() >= 2) {
            long temp1 = heap.poll();
            long temp2 = heap.poll();

            result += temp1 + temp2;
            heap.offer(temp1 + temp2);
        }
        System.out.println(result);
    }
}