import java.io.*;
import java.util.*;

public class Main {
    static long swap = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(swap);
    }

    static void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int n = mid - low + 1;
        int m = high - mid;

        int[] leftArr = new int[n];
        int[] rightArr = new int[m];

        for(int i = 0; i < n; i++) {
            leftArr[i] = arr[low + i];
        }

        for(int i = 0; i < m; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = low;
        while (i < n && j < m) {
            if(leftArr[i] > rightArr[j]) {
                arr[k] = rightArr[j];
                j++;
                swap += n - i;
            } else {
                arr[k] = leftArr[i];
                i++;
            }
            k++;
        }

        while (i < n) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < m) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}