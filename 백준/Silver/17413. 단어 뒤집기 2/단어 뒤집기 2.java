import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split("");

        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < strArr.length; i++) {
            if(strArr[i].equals("<")) {
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }

                while(true) {
                    list.add(strArr[i]);
                    i++;
                    if(strArr[i].equals(">")) {
                        list.add(strArr[i]);
                        break;
                    }
                }
            } else if(strArr[i].equals(" ")) {
                
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }
                list.add(strArr[i]);
            } else {
                stack.push(strArr[i]);
            }
        }

        while (!stack.isEmpty()) list.add(stack.pop());

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s);
        }

        System.out.println(sb);
    }
}