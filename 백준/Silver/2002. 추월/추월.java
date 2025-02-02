import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(map.get(br.readLine()));
        }

        int result = 0;
        // 출차 순서 기준으로 해당 차의 순서가 뒷 차보다 빨리 나왔으면 추월
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(list.get(i) > list.get(j)) {
                    result++;
                    break; // 추월 했음을 증명하면 됐으므로 break
                }
            }
        }

        System.out.println(result);
    }
}