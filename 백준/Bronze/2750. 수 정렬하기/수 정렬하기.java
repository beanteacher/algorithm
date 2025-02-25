import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		for(int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		bubbleSort(n, arr);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n+1; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
	}
	
	static void bubbleSort(int n, int[] arr) {
		
		for(int i = 1; i <= n+1; i++) {
			for(int j = 1; j <= n-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
