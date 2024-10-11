import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 1; i < num+1; i++) {
            int sum = 0;
            for(int j = i; j < num+1; j++) {
                sum += j;
                if(sum >= num) {
                    if(sum == num) {
                        result++;
                    }
                    break;
                }
            }
        }
        System.out.print(result);
    }
}