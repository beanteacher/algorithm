import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<String> stack = new Stack<>();
            boolean isVPS = true;
            for(int j = 0; j < str.length(); j++) {
                if(stack.isEmpty() && str.charAt(j) == ')') {
                    isVPS = false;
                    break;
                }

                if(str.charAt(j) == '(') {
                    stack.push("(");
                } else {
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) isVPS = false;
            
            if(isVPS) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}