import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputArr = input.split("");
        
        Stack<String> stack = new Stack<>();
        
        int pipe = 0;
        
        for(int i = 0; i < inputArr.length; i++) {
            if(inputArr[i].equals("(")) {
                stack.push(inputArr[i]);
            } else {
                stack.pop();  
                
                if(inputArr[i-1].equals("(")) {
                    pipe += stack.size();
                } else {
                    pipe++;
                }
            }
        }
        System.out.println(pipe);
    }
}