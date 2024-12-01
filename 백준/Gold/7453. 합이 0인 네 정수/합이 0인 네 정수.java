import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] aArr = new int[n];
		int[] bArr = new int[n];
		int[] cArr = new int[n];
		int[] dArr = new int[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			aArr[i] = Integer.parseInt(st.nextToken());
			bArr[i] = Integer.parseInt(st.nextToken());
			cArr[i] = Integer.parseInt(st.nextToken());
			dArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] abArr = new int[n*n];
		int[] cdArr = new int[n*n];
		int idx = 0; // AB와 CD 배열의 인덱스를 관리
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				abArr[idx] = aArr[i] + bArr[j];
				cdArr[idx] = cArr[i] + dArr[j];
				idx++;
			}
		}
		
		Arrays.sort(abArr);
		Arrays.sort(cdArr);
		
		int left = 0;
		int right = n*n - 1;
		
		long result = 0;
		
		while(left < n*n && right >= 0) {
			if(abArr[left] + cdArr[right] < 0) {
				left++; // 합이 0보다 작다면 합을 키워야한다.
			} else if(abArr[left] + cdArr[right] > 0) {
				right--; // 합이 0보다 크다면 합을 줄여야한다.
			} else {
				long leftCount = 0; // ab배열에서 현재 값의 개수
				long rightCount = 0; // cd배열에서 현재 값의 개수
				int leftValue = abArr[left];
				int rightValue = cdArr[right];
				
				// abArr에서 같은 값의 개수 세기
				while(left < abArr.length && abArr[left] == leftValue) {
					leftCount++;
					left++;
				} 
				
				// cdArr에서 같은 값의 개수 세기
				while(right >= 0 && cdArr[right] == rightValue) {
					rightCount++;
					right--;
				}
				
				result += leftCount * rightCount;
			}
		}
		System.out.println(result);
	}
}