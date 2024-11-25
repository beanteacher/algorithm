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
        
        int result = 2000000001; // result 초기화를 배열의 마지막 값 혹은 문제 조건(0 ≤ |A[i]| ≤ 1,000,000,000)에 의한 1,000,000,001으로 초기화 시 왜 작동하지 않는가 ?

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int diff = nArr[j] - nArr[i];
                if(diff >= m) {
                    if(result > diff) {
                        result = diff;
                    } // result = Math.min(result, diff)로 수정 가능
                    
                    break; // result는 최소값을 구하는 것이니 이 이상 더 큰 차이는 필요 없으므로 break
                }
            }
        }
        System.out.println(result);
    }
}