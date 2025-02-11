package org.algorithm.data.structure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxHeap {

    Integer[] heap;
    final int ROOT_NODE_INDEX = 0;
    int size = 0; // 저장된 노드의 개수

    public MaxHeap(int length) {
        this.heap = new Integer[length];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean hasLeftChild(int index) {
        return size > getLeftChildIndex(index);
    }

    private boolean hasRightChild(int index) {
        return size > getRightChildIndex(index);
    }

    private void swap(int index1, int index2) {
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    // 힙에 값 넣기
    public void offer(int key) {
        if(heap.length == size) { // 10
            // 힙이 가득차면 힙의 사이즈를 늘려준다.
            heap = Arrays.copyOf(heap, heap.length + 1);
        }

        // 힙에 값을 넣기 위해 사이즈의 맨 마지막에 key를 넣고
        heap[size++] = key; // heap[10] = key
        upHeap(size - 1);
        System.out.println(key + "삽입 완료");
    }

     // upHeap 동작(부모와 비교하며 현재 값이 부모의 값보다 크면 값 swap)
    private void upHeap(int index) {
        while (index != ROOT_NODE_INDEX && heap[index] > heap[getParentIndex(index)]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public int poll() {
        int lastNodeIndex = size - 1;
        swap(ROOT_NODE_INDEX, lastNodeIndex);

        int root = heap[lastNodeIndex];

        System.out.println(heap[lastNodeIndex] + "제거 완료");

        heap[lastNodeIndex] = null;
        size--;

        downHeap(ROOT_NODE_INDEX);

        return root;
    }

    public int peek() {
        return heap[ROOT_NODE_INDEX];
    }

    private void downHeap(int index) {
        int childIndex;

        // 완전 이진트리 : 왼쪽부터 담기기때문에 왼쪽 먼저 확인
        if(hasLeftChild(index)) {
            childIndex = getBiggerChildIndex(index);
        } else {
            return;
        }

        // 자식이 더 큰 경우 maxHeap의 경우 DownHeap 동작 실행
        while (size > index && hasLeftChild(index) && heap[index] < heap[childIndex]) {
            swap(index, childIndex);

            // 계속 반복하기 위해 index 값과 childIndex값 변경
            index = childIndex;
            childIndex = getBiggerChildIndex(index);
        }
    }

    private int getBiggerChildIndex(int index) {
        // 우측 자식 노드가 존재하면 둘 중 큰 값을 반환
        if(hasRightChild(index)) {
            return heap[getLeftChildIndex(index)] >= heap[getRightChildIndex(index)] ? getLeftChildIndex(index) : getRightChildIndex(index);
        } else if(hasLeftChild(index)){ // 좌측만 존재하면 좌측 노드 반환
            return getLeftChildIndex(index);
        } else { // 자식노드가 없는 Leaf 노드인 경우
            return -1;
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.offer(11);
        heap.offer(12);
        heap.offer(10);
        heap.offer(19);
        heap.offer(7);
        heap.offer(13);
        heap.offer(1);

        System.out.println("다음 값은 ?" + heap.poll());
        System.out.println("다음 값은 ?" + heap.poll());
        System.out.println("다음 값은 ?" + heap.poll());
        System.out.println("다음 값은 ?" + heap.poll());
        System.out.println("다음 값은 ?" + heap.poll());
        System.out.println("다음 값은 ?" + heap.poll());
        PriorityQueue<Integer > queue = new PriorityQueue<>();

    }
}