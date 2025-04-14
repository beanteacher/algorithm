import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 일 수
        int m = Integer.parseInt(st.nextToken()); // 인출 횟수

        int[] arr = new int[n];
        int min = 0;
        int max = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, arr[i]); // 최소 인출금은 하루 최대 소비
            max += arr[i]; // 최대 인출금은 모든 날 합
        }

        int answer = max;

        while(min <= max) {
            int mid = (min + max) / 2;

            int count = 1; // 인출 횟수
            int money = mid;

            for(int i = 0; i < n; i++) {
                if(money < arr[i]) {
                    count++;
                    money = mid;
                }
                money -= arr[i];
            }

            if(count > m) {
                min = mid + 1; // 더 큰 금액이 필요
            } else {
                answer = mid; // 가능한 금액, 더 줄여볼 수 있음
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}