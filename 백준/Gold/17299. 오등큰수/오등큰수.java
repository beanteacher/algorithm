import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		int[] ngeArr = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = n-1; i >= 0; i--) {
			while(!stack.isEmpty() && map.get(stack.peek()) <= map.get(arr[i])) {
				stack.pop();
			}
			
			ngeArr[i] = stack.isEmpty() ? -1 : stack.peek();
			
			stack.push(arr[i]);
		}
		
		// 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : ngeArr) {
          sb.append(num).append(" ");
        }
    
        System.out.println(sb.toString().trim());
	}
}