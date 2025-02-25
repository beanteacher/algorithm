import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        insertSort(arr);
        
        int result = 0;

        // 인덱스 기준 (0 + 0, 1 + 0, 1, 2 + ... + 0, 1, 2, ..., n)을 수행하기 위한 이중 for문
        for(int i = 0; i < n; i++) {
            result += arr[i];

            for(int j = 0; j < i; j++) {
                result += arr[j];
            }
        }

        System.out.println(result);
    }

    static void insertSort(int[] arr) {

        for(int i = 1; i < arr.length; i++) {
            int data = arr[i];
            int j = i - 1;

            // arr[i] 값보다 앞쪽에 큰 값이 있으면 바로 인접한 값과 자리 교체
            while(j >= 0  && arr[j] > data) {
                arr[j+1] = arr[j];
                j--;
            }

            // 자리교체가 모두 끝났으면 마지막으로 arr[i]값이 들어갈 위치와 자리 교체
            arr[j+1] = data;
        }
    }
}