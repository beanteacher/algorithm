import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int result = 0;

        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int currentLine = Integer.parseInt(st.nextToken());
            int pret = Integer.parseInt(st.nextToken());

            Stack<Integer> stack = map.getOrDefault(currentLine, new Stack<>());

            while(!stack.isEmpty() && stack.peek() > pret) {
                stack.pop();
                result++;
            }

            if(stack.isEmpty() || stack.peek() != pret) {
                stack.push(pret);
                result++;
            }

            map.put(currentLine, stack);
        }
        System.out.println(result);
    }
}