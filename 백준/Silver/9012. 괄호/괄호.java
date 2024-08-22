import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();

        for(int k = 0; k < count; k++) {
            String answer = "";
            String input = br.readLine();
            String[] inputArr = input.split("");

            for(int i = 0; i < inputArr.length; i++) {
                try {
                    if(inputArr[i].equals("(")) {
                        stack.push(inputArr[i]);
                    } else {
                        stack.pop();
                    }
                } catch (Exception e) {
                    answer = "NO";
                    break;
                }
            }
            if(answer.equals("NO") || !stack.isEmpty()) {
                System.out.println("NO");
                stack.clear();
                continue;
            }
            System.out.println("YES");
        }
    }
}