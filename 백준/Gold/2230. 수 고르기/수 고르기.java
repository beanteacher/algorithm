import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nArr = new int[n];
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nArr);
        
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int diff = nArr[j] - nArr[i];
                if(diff >= m) {
                    if(result > diff) {
                        result = diff;
                    }
                    break;
                }
            }
        }
        System.out.println(result);
    }
}