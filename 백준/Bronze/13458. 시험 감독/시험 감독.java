import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = n;

        for(int i = 0; i < n; i++) {
            int student = nArr[i] - b; // 총 감독이 감시할 학생을 제외한 학생 수
            if(student > 0 ) {
	            result += student / c; // 부 감독의 수
	            
	            if(student % c != 0) { // 나머지가 생긴다면 감독이 한 명 더 필요하다.
	                result++;
	            }
            }
        }
        System.out.println(result);
    }
}