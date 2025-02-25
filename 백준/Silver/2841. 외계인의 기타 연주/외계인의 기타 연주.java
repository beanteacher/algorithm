import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // 손가락으로 프렛을 누르면 증가, 손가락으로 프렛을 떼면 증가
        int result = 0;

        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int line = Integer.parseInt(st.nextToken()); // 줄
            int pret = Integer.parseInt(st.nextToken()); // 프렛

            // 다른 줄을 누르고 있어도 현재 줄에는 영향을 미치지 않는다.
            // 같은 줄끼리만 비교하면 되므로 Map에서 같은 줄을 저장한 Stack을 가져온다.
            Stack<Integer> stack = map.getOrDefault(line, new Stack<>());

            // stack이 비어있지 않고 마지막에 누른 프렛이 현재 프렛보다 크다면 음을 내기 위해 프렛에 손을 떼어준다.
            while(!stack.isEmpty() && stack.peek() > pret) {
                stack.pop();
                result++;
            }

            // stack이 비어있으면 아무 프렛도 누르지 않았기 때문에 프렛을 눌러준다.
            // 마지막에 누른 프렛이 현재 프렛과 같지 않으면 프렛을 눌러준다.
            if(stack.isEmpty() || stack.peek() != pret) {
                stack.push(pret);
                result++;
            }
            
            map.put(line, stack);
        }
        System.out.println(result);
    }
}