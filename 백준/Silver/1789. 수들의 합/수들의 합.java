import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        
        int result = 0;
        long sum = 0;
        while(true) {
            if(s < sum) break;
            result++;
            
            sum += result;
        }
        System.out.println(result-1);
    }
}