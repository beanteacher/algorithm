
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // A의 갯수
            int m = Integer.parseInt(st.nextToken()); // B의 갯수
            int[] nArr = new int[n];
            int[] mArr = new int[m];

            st = new StringTokenizer(br.readLine());    // A의 크기
            for(int j = 0; j < n; j++) {
                nArr[j] = Integer.parseInt(st.nextToken()); // A의 크기(배열)
            }

            st = new StringTokenizer(br.readLine());    // B의 크기
            for(int j = 0; j < m; j++) {
                mArr[j] = Integer.parseInt(st.nextToken()); // B의 크기(배열)
            }

            Arrays.sort(nArr);
            Arrays.sort(mArr);

            int result = 0;
            for(int j = 0; j < n; j++) { // A를 기준으로 A가 더 크면 result를 올리기 때문에 A를 기준으로 반복  
                int mCount = 0;

                while(mCount != m) { // mCount는 m만큼 반복하지만 
                    if(nArr[j]<=mArr[mCount]) { // 만약 mArr[mCount]가 nArr[j]보다 크거나 같으면 반복 종료
                        break;
                    } else {
                        mCount++;
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}