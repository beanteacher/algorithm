package org.study;

import java.util.*;
public class MyComparable {
    static class MyInteger implements Comparable<MyInteger> {
        int value;

        public MyInteger(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(MyInteger o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        MyInteger[] arr = new MyInteger[10];

        for(int i = 0; i < 10; i++) {
            arr[i] = new MyInteger((int) (Math.random() * 100));
        }
        System.out.println("정렬 전" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("정렬 후" + Arrays.toString(arr));
    }
}
