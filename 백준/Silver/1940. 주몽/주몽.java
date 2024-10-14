import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrLength = Integer.parseInt(br.readLine());
        int sum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[arrLength];
        for(int i = 0; i < arrLength; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = arrLength - 1;
        int result = 0;
        while(start < end) {
            if(arr[start] + arr[end] > sum) {
                end--;
            } else if (arr[start] + arr[end] < sum) {
                start++;
            } else if (arr[start] + arr[end] == sum) {
                start++;
                end--;

                result++;
            }
        }
        System.out.println(result);
    }
}

