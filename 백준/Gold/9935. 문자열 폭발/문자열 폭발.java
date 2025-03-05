import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bombStr = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bombStr.length()) {
                boolean flag = true;

                for(int j = 0; j < bombStr.length(); j++) {
                    if(stack.get(stack.size() - bombStr.length() + j) != bombStr.charAt(j)) { // stack의 size - bombStr ~ size까지의 문자가 폭탄 문자와 같은 지 판단 
                        flag = false;
                        break;
                    }
                }
                if(flag) { // 같다면 스택에서 폭탄 문자열 제거
                    for(int j = 0; j < bombStr.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            for(Character s : stack) {
                sb.append(s);
            }
        }
        System.out.println(sb);
    }
}