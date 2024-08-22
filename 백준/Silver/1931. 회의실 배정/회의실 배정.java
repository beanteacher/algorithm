/*
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
*/

import java.util.*;
import java.io.*;

public class Main {
     public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int repeat = Integer.parseInt(br.readLine());
         int[][] arr = new int[repeat][2];
         for(int i = 0; i < repeat; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             arr[i][0] = Integer.parseInt(st.nextToken());
             arr[i][1] = Integer.parseInt(st.nextToken());
         }
         
         Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
         });
         
         int count = 0;
         int finish = 0;
         
         for(int i = 0; i < repeat; i++) {
             
             if(arr[i][0] >= finish) {
                 count++;
                 finish = arr[i][1];
             }
         }
         System.out.println(count);
     }
}