import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 원하는 부분합

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        long sum = 0;
        
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            
            // 정답이 이해가 가질 않네요.
            count += map.getOrDefault(sum - k, 0);
            
            // 현재 누적 합을 해시맵에 저장
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(count);
    }
}