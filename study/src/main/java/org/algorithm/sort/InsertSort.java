package org.algorithm.sort;

import java.util.*;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 4, 1, 3, 2};

        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        // 삽입 정렬은 index 1부터 시작하기 때문에 1부터 배열 크기만큼 정렬한다.
        for(int i = 1; i < arr.length; i++) {
            // key = 선택 데이터
            int key = arr[i];
            int j = i - 1;
            // 4를 저장해두고 5 4 1 3 2 -> 5 5 1 3 2 -> 4 5 1 3 2
            // 1을 저장해두고 4 5 1 3 2 -> 4 5 5 3 2 -> 4 1 5 3 2 -> 1 4 5 3 2
            // 1 4 3 5 2 -> 1 3 4 5 2
            // 1 3 4 2 5 -> 1 3 2 4 5 -> 1 2 3 4 5
            // 선택 데이터보다 앞 인덱스에 큰 값이 존재하지 않을 때까지 위치 변경
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
