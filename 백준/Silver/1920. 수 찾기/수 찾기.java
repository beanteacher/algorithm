import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}