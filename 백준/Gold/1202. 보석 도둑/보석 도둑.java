import java.util.*;
import java.io.*;

public class Main {
    static class Jewelry {
        int weight;
        int value;

        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewelry> jewelryHeap = new PriorityQueue<>((j1, j2) -> j1.weight - j2.weight);

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 11보다 작은 무게를 가진 보석 중 가장 비싼 것.
            jewelryHeap.offer(new Jewelry(m, v));
        }

        int[] arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long result = 0;
        PriorityQueue<Jewelry> jewelryValueHeap = new PriorityQueue<>((j1, j2) -> j2.value - j1.value);
        for(int i = 0; i < k; i++) {
            while(!jewelryHeap.isEmpty() && arr[i] >= jewelryHeap.peek().weight) { // 11 > 5
                jewelryValueHeap.offer(jewelryHeap.poll());
            }

            result += !jewelryValueHeap.isEmpty() ? jewelryValueHeap.poll().value : 0;
        }

        System.out.println(result);
    }
}
