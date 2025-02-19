import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println(arr[k-1]);
    }

    static void quickSort(int[] arr, int low, int high) {

        if(low >= high) {
            return;
        }

        int pivot = low + (high - low) / 2; // 2
        int pivotValue = arr[pivot];
        int start = low;
        int end = high;

        while(start <= end) {
            while(pivotValue > arr[start]) {
                start++;
            }

            while(arr[end] > pivotValue) {
                end--;
            }

            if(start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
        }

        quickSort(arr, low, end); // 0 ~ 2
        quickSort(arr, start, high); // 3 ~ 4
    }
}