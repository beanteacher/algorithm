import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[10001];  // 1 ~ 10000 범위의 숫자 개수 저장

        // 입력값 개수 카운팅
        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        // 정렬된 결과 출력
        for (int i = 1; i <= 10000; i++) {
            while (count[i]-- > 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}