import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String str = br.readLine();
            String[] strArr = str.split("");

            Stack<String> leftStack = new Stack<>();
            Stack<String> rightStack = new Stack<>();

            for(int j = 0; j < strArr.length; j++) {
                if(strArr[j].equals("<")) {
                    if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                } else if(strArr[j].equals(">")) {
                    if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                } else if(strArr[j].equals("-")) {
                    if(!leftStack.isEmpty()) leftStack.pop();
                } else {
                    leftStack.push(strArr[j]);
                }
            }

            while(!rightStack.isEmpty()) {
				leftStack.push(rightStack.pop());
			}
            System.out.println(leftStack.toString().substring(1, leftStack.toString().length() - 1).replace(", ", ""));
        }
    }
}