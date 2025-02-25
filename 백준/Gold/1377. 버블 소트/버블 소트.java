import java.util.*;
import java.io.*;

public class Main {
	static class Data implements Comparable<Data> {
		int value;
		int index;
		
		public Data(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
		@Override
		public int compareTo(Data data) {
			return this.value - data.value;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Data[] arr = new Data[n];
		for(int i = 0; i < n; i++) {
			arr[i] = new Data(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(arr);
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i].index - i > max) {
				max = arr[i].index - i;
			}
		}
		
		System.out.println(max + 1);
	}
}
