package org.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {38, 27, 43, 3, 9, 82, 10, 22};

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int left, int right) {
        if(left == right) return;

        int mid = (left + right) / 2;

        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n = mid - left + 1;
        int m = right - mid;

        int[] leftArr = new int[n];
        int[] rightArr = new int[m];

        for(int i = 0; i < n; i++) {
            leftArr[i] = arr[left+i];
        }

        for(int i = 0; i < m; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while(i < n && j < m) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // 왼쪽 배열의 남아있는 내용들 채워주기
        while(i < n) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        // 오른쪽 배열의 남아있는 내용들 채워주기
        while(j < m) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
