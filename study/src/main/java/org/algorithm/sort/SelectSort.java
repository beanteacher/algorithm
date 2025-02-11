package org.algorithm.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 4, 1, 3, 2};

        selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
