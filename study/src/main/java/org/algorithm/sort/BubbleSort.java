package org.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 4, 1, 3, 2};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 1; j < arr.length - i; j++) {
                // 앞 인덱스 데이터와 뒷 인덱스 데이터와 비교해서 앞이 더 크면 위치 변경
                if(arr[j] < arr[j-1]) {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
