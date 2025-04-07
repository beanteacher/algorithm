import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> negativePQ = new PriorityQueue<>(); // 음수거나 0인 경우 오름차순
		PriorityQueue<Integer> positivePQ = new PriorityQueue<>((a,b) -> b - a); // 양수인 경우 내림차순
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > 0) {
				positivePQ.offer(num);
			} else {
				negativePQ.offer(num);
			}
		}
		
		int result = 0;
		
		while(!negativePQ.isEmpty()) {
			int num = negativePQ.poll();
			
			if(negativePQ.isEmpty()) { // queue가 비었다면 더 이상 해줄 게 없으므로 종료
				result += num;
				break;
			}
			
			result += num * negativePQ.poll(); // 두 개 이상 남았었다면 곱하여 결과 값에 더해준다.
		}
		
		while(!positivePQ.isEmpty()) {
			int num = positivePQ.poll();
			
			if(positivePQ.isEmpty()) {
				result += num;
				break;
			}
			
			if(positivePQ.peek() == 1) {
				result += num;
			} else {
				result += num * positivePQ.poll();
			}
		}
		
		System.out.println(result);
	}
}