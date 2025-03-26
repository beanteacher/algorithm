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

        Integer[] digits = new Integer[26]; // 역순 정렬인 Collections.reverseOrder()를 수행하기 위해 Integer로 선언 알파벳의 갯수 26개
        Arrays.fill(digits, 0); // 초깃값 0으로 초기화
        for(int i = 0; i < n; i++) {
            int temp = (int) Math.pow(10, arr[i].length() - 1); // 제곱 수 구하는 방법
            for(int j = 0; j < arr[i].length(); j++) {
                // GCF
                // ACDEB의 경우
                // A = 10000, C = 1010, D = 100, G = 100, ...라는 가중치가 부여된다.
                digits[(int) arr[i].charAt(j) - 65] += temp; // 자릿수의 빈도수 만큼 곱셈하기

                temp /= 10; // 다음 자릿수를 위해 10 나누기
            }
        }

        Arrays.sort(digits, Collections.reverseOrder()); // 역순 정렬

        int num = 9;
        int result = 0;

        for(int i = 0; i < digits.length; i++) {
            if(digits[i] == 0) { // 가중치가 0인 경우
                break;
            }

            result += digits[i] * num--; // 가중치가 가장 높은 순서대로 9, 8, 7, ...을 해준다.
        }

        System.out.println(result);
    }
}