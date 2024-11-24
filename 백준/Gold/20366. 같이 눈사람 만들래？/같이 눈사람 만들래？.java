import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> heightList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = Integer.MAX_VALUE;
		Arrays.sort(nArr);
		
		for(int i = 0; i < n; i++) { // 안나 눈사람 아래 눈 지름
			for(int j = i+1; j < n; j++) { // 안나 눈사람 위 눈 지름
				int annaHeight = nArr[i] + nArr[j]; // 안나 눈사람 키
				
				int start = 0;
				int end = n-1;
				while(start < end) {
					if(start == i || start == j) { // 엘사 눈사람 아래 지름을 지정하는데 이미 사용한 눈이라면
						start++;
						continue;
					}
					if(end == i || end == j) { // 엘사 눈사람 위 지름을 지정하는데 이미 사용한 눈이라면
						end--;
						continue;
					}
					
					int elsaHeight = nArr[start] + nArr[end]; // 엘사 눈사람 키
					result = Math.min(result, Math.abs(annaHeight - elsaHeight));
					if(annaHeight > elsaHeight) { // 안나 눈사람의 키가 엘사 눈사람의 키보다 크면
						start++; // 안나 눈사람과 엘사 눈사람의 키 차이를 좁히기 위해(정렬이 되었기 때문) 엘사 눈사람의 아래 지름을 증가시켜준다.
					} else if(annaHeight < elsaHeight) { // 안나 눈사람의 키가 엘사 눈사람의 키보다 작으면
						end--; // 엘사 눈사람과 안나 눈사람의 키 차이를 좁히기 위해 엘사 눈사람의 위 지름을 감소시켜준다.
					} else { // 같은 경우
						System.out.println(annaHeight - elsaHeight); // 가장 작은 값은 0이므로 return
						return;
					}
				}
			}
		}
			
		System.out.println(result);
	}
}