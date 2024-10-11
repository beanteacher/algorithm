/*
5 3
5 4 3 2 1
1 3
2 4
5 5
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        int numCount = Integer.parseInt(st.nextToken());
        int repeatCount = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[numCount + 1];
        nums[0] = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < numCount + 1; i++) {
            nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < repeatCount; i++) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int result = nums[end] - nums[start-1];
            
            System.out.println(result);
        }
        
    }
}