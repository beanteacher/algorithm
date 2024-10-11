
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int n = Integer.parseInt(br.readLine());
        
        String str = br.readLine();
        String[] strArr = str.split("");

        for(int i = 0; i < n; i++) {
            result += Integer.parseInt(strArr[i]);
        }
        System.out.print(result);
    }
}