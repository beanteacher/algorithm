/*10 4200
1
5
10
50
100
500
1000
5000
10000
50000*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int repeat = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        Stack<Integer> billStack = new Stack();
        int count = 0;
        for(int i = 0; i < repeat; i++) {
            billStack.push(Integer.parseInt(br.readLine()));
        }
        
        while(!billStack.isEmpty()) {
            int bill = billStack.pop();
            
            if(price / bill > 0) {
                int value = price / bill;
                count += value;
                price -= bill * value;
            }
        }
        System.out.println(count);
    }
}