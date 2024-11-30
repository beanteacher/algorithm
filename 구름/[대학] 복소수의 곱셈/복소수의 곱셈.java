import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] realNumberArr = new int[n];
        int[] imaginaryNumberArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] complexNumber = st.nextToken().split("\\+");
            int realNumber = Integer.parseInt(complexNumber[0]);
            int imaginaryNumber = Integer.parseInt(complexNumber[1].substring(0, complexNumber[1].length() - 1));

            realNumberArr[i] = realNumber;
            imaginaryNumberArr[i] = imaginaryNumber;
        }

        int a = realNumberArr[0];
        int b = imaginaryNumberArr[0];

        for(int i = 1; i < n; i++) {
            int beforeCalculatorA = a; // 계산하기 전 a
            int beforeCalculatorB = b; // 계산하기 전 b
            int c = realNumberArr[i];
            int d = imaginaryNumberArr[i];

            a = beforeCalculatorA*c - beforeCalculatorB*d; // a*c - b*d
            b = beforeCalculatorA*d + beforeCalculatorB*c; // a*d + b*c를 계산하면 a가 변경되어 값이 달라져서 변경되기 전 a와 b를 선언하여 사용
        }

        System.out.println(Math.abs(a)%100 + " " + Math.abs(b)%7);
    }
}
