import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        // n의 부분 합을 담아주기 위해 nMap에 n의 부분 합과 부분 합의 개수을 저장한다.
        Map<Integer, Integer> nMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nArr[j];

                nMap.put(sum, nMap.getOrDefault(sum, 0) + 1);
            }
        }

        // m의 부분 합을 담아주기 위해 mMap에 m의 부분 합과 부분 합의 개수을 저장한다.
        Map<Integer, Integer> mMap = new HashMap<>();
        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = i; j < m; j++) {
                sum += mArr[j];

                mMap.put(sum, mMap.getOrDefault(sum, 0) + 1);
            }
        }

        long result = 0;
        for(Map.Entry<Integer, Integer> entry : nMap.entrySet()) {
            int nSum = entry.getKey();
            long nCount = entry.getValue();

            long mCount = mMap.getOrDefault(t - nSum, 0);

            result += nCount * mCount;
        }
        System.out.println(result);
    }
}