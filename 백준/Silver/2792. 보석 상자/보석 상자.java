import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 아이들의 수
        int m = Integer.parseInt(st.nextToken()); // 색상의 수

        int[] arr = new int[m];
        int low = 1;
        int high = 0;

        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }

        while(low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;

            for(int element : arr) {
                sum += element / mid;
                if(element % mid != 0) sum++;
            }

            if(sum > n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(low);
    }
}