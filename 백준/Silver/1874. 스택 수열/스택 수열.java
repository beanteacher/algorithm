import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        List<String> list = new ArrayList<>();

        int count = 0;
        boolean isYn = true;
        for(int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());

            if(count < h) {

                while(count < h) {
                    list.add("+");
                    leftStack.push(count+1);
                    count++;
                }
            }
            list.add("-");
            int element = leftStack.pop();
            if(h != element) {
                isYn = false;
                break;
            }
            rightStack.push(element);
        }

        // System.out.println(rightStack);
        if(isYn) {
            for(String s : list) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }

    }
}