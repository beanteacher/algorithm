package org.algorithm.sort;
import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[] {38, 27, 43, 3, 9, 82, 10, 22};

        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 기수 정렬
    static void radixSort(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max); // 배열의 요소 중 가장 큰 값을 찾는 과정
        }

        // 가장 큰 값 / i가 0보다 크지 않다면 arr의 요소가 모두 i보다 작다는 의미
        for(int i = 1; max / i > 0; i*=10) {
            countSort(arr, i);
        }
    }

    // 개수 정렬 시작
    static void countSort(int[] arr, int digit) {
        Map<Integer, Queue<Integer>> map = new HashMap<>(); // 큐를 보관할 Map 선언

        for(int i = 0; i < arr.length; i++) {
            int value = (arr[i] / digit) % 10; // (arr의 요소 / digit) % 10 -> digit 자릿수의 숫자만 추출

            Queue<Integer> queue = map.getOrDefault(value, new LinkedList<>()); // 해당 키의 큐가 존재하면 map에서 가져오고 그렇지 않다면 생성
            queue.offer(arr[i]); // 큐에 arr의 요소를 정렬된 순서대로 넣는다.

            map.put(value, queue);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet()); // map의 키를 오름차순 정렬
        Collections.sort(keySet);

        int index = 0;
        // 키가 0인 큐부터 차례대로 존재하는 큐의 요소를 모두 arr에 기존 자리의 값을 초기화하며 정렬
        for(int i = 0; i < keySet.size(); i++) {
            Queue<Integer> queue = map.get(keySet.get(i));

            while (!queue.isEmpty()) {
                arr[index++] = queue.poll();
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
