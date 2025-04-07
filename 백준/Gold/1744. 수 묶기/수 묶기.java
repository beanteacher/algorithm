import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int minusCount = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if(arr[i] < 0) {
                minusCount++;
            }
        }

        if(n == 1) {
            System.out.println(arr[0]);
            return;
        }

        Arrays.sort(arr);

        int sum = 0;
        int i = 0;
        int j = n-1;

        while(i < n && arr[i] < 0) {
            if(minusCount % 2 == 0) {
                if(i+1 < n && arr[i] < 0 && arr[i+1] < 0)  {
                    sum += arr[i++] * arr[i++];
                } else {
                    sum += arr[i++];
                }
            } else {
                if(i+1 < n && arr[i] < 0 && (arr[i+1] < 0 || arr[i+1] == 0))  {
                    sum += arr[i++] * arr[i++];
                } else {
                    sum += arr[i++];
                }
            }
        }

        while(j >= 0 && arr[j] >= 0) {
            if(j-1 >= 0 && arr[j] > 1 && arr[j-1] > 1) {
                sum += arr[j--] * arr[j--];
            } else {
                sum += arr[j--];
            }
        }

        System.out.println(sum);
    }
}