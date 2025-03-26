import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Integer[] digits = new Integer[26];
        Arrays.fill(digits, 0);
        for(int i = 0; i < n; i++) {
            int temp = (int) Math.pow(10, arr[i].length() - 1); // 제곱 수
            for(int j = 0; j < arr[i].length(); j++) {
                digits[(int) arr[i].charAt(j) - 65] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(digits, Collections.reverseOrder());

        int num = 9;
        int result = 0;

        for(int i = 0; i < digits.length; i++) {
            if(digits[i] == 0) {
                break;
            }

            result += digits[i] * num--;
        }

        System.out.println(result);
    }
}