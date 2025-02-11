
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] inputArr = br.readLine().toCharArray();

        Deque<String> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            if(inputArr[i] == '(') { // ( 가 오면 deque에 (를 넣는다.
                deque.addLast("(");
            } else if(inputArr[i] == ')') {
                Deque<String> innerDeque = new LinkedList<>();

                while(true) { // ) 가 오면 deque에서 하나씩 꺼내는데

                    String str = deque.removeLast();

                    if(str.equals("(")) { // deque에서 꺼낸 값이 (면 innerDeque가 비게 될 때까지 sb에 추가로 넣고 deque에도 추가로 넣는다. [ a b c c d 를 만들기 위해]
                        while(!innerDeque.isEmpty()) {
                            String innerStr = innerDeque.removeLast();
                            sb.append(innerStr);
                            deque.addLast(innerStr);
                        }
                        break;
                    } else { // (가 아닌데 deque가 비어있지 않다면 innerDeque에 하나씩 다시 넣는다. [ deque에 ( b c d 를 만들어주기 위해 ]
                        if(!deque.isEmpty()) {
                            innerDeque.addLast(str);
                        }
                    }
                }
            } else {
                if(!deque.isEmpty()) { // deque가 비어있지 않다면 문자열에도 더 해주고 deque에도 넣어준다.
                    deque.addLast(String.valueOf(inputArr[i]));
                }
                sb.append(inputArr[i]);
            }
            System.out.println("inputArr[i] : " + inputArr[i] + ", i : " + i + " -> " + deque + ", sb : " + sb);
        }

        System.out.println(sb.toString().length());
    }
}
