import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int result = 0;
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push("(");
            } else {
                if(str.charAt(i - 1) == '(') {
                    stack.pop();
                    result += stack.size();
                } else {
                    stack.pop();
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}