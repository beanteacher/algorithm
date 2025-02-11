package org.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] {38, 27, 43, 3, 9, 82, 10, 22};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        // pivot 값 선정
        int pivot = low + (high - low) / 2;
        int pivotValue = arr[pivot];

        int left = low;
        int right = high;
        // pivot을 기준으로 왼쪽과 오른쪽 자리 변경(pivot보다 왼쪽은 작게 오른쪽은 크게)
        while(left <= right) {
            // 자리 교환을 위해 left에 pivot보다 큰 값을 탐색
            while (arr[left] < pivotValue) {
                left++;
            }
            // 자리 교환을 위해 pivot보다 작은 값을 탐색
            while (arr[right] > pivotValue) {
                right--;
            }

            // left와 right 위치를 변경
            if(left <= right) {
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;

                left++;
                right--;
            }
        }

        quickSort(arr, low, right);
        quickSort(arr, left, high);
    }
}
