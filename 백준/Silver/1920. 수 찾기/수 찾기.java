import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(A);
        
        for (int target : B) {
            int start = 0;
            int end = A.length - 1;
            
            boolean found = false;


            while (start <= end) {
                int mid = (start + end) / 2;
                if (A[mid] == target) {
                    found = true;
                    break;
                } else if (A[mid] < target) {
                    start = mid + 1; // 오른쪽으로 이동
                } else {
                    end = mid - 1; // 왼쪽으로 이동
                }
            }

            if (found) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
        
        
        
        
    }
}