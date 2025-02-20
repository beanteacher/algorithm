import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(arr, 0, arr.length - 1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void mergeSort(int[] arr, int left, int right) {
		if(left == right) return;
		
		int mid = left + (right - left) / 2;
		
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		
		merge(arr, left, mid, right);
	}
	
	static void merge(int[] arr, int left, int mid, int right) { 
	
		int n = mid - left + 1;
		int m = right - mid;
		
		int[] leftArr = new int[n];
		int[] rightArr = new int[m];
		
		for(int i = 0; i < n; i++) {
			leftArr[i] = arr[left + i];
		}
		
		for(int i = 0; i < m; i++) {
			rightArr[i] = arr[mid + i + 1];
		}
		
		int i = 0;
		int j = 0;
		int k = left;
		
		while(i < n && j < m) {
			if(leftArr[i] > rightArr[j]) {
				arr[k] = rightArr[j];
				j++;
			} else {
				arr[k] = leftArr[i];
				i++;
			}
			k++;
		}
		
		while(i < n) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		
		while(j < m) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}
}