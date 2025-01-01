import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int page = 0;
        int pageSum = 0;
        int retry = 0;
        while (num > pageSum) {
            page += 1;
            pageSum += page;

            page += 1;
            pageSum += page;
            retry++;
        }

        page = 0;

        Number[] numberArr = new Number[retry];
        for(int i = 0; i < retry; i++) {
            int odd = page += 1;
            int even = page += 1;
            numberArr[i] = new Number(odd, even);
        }

        for (Number number : numberArr) {
            if (pageSum - (number.odd + number.even) == num) {
                System.out.println(number.odd);
            }
        }
    }

    public static class Number {
        private final int odd;
        private final int even;

        public Number(int odd, int even) {
            this.odd = odd;
            this.even = even;
        }
    }
}