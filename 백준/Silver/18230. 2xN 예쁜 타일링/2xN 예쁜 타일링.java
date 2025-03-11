import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Integer[] aArr = new Integer[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(aArr, Comparator.reverseOrder()); // 내림차순 정렬

        Integer[] bArr = new Integer[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bArr, Comparator.reverseOrder()); // 내림차순 정렬

        int max = 0;
        int restTiles = n;
        int aIndex = 0; // 2x1 타일 인덱스
        int bIndex = 0; // 2x2 타일 인덱스

        // N이 홀수라면 2x1 타일을 하나 먼저 쓴다.
        if (restTiles % 2 == 1 && a > 0) {
            max += aArr[aIndex++]; // 가장 큰 2x1 타일을 하나 선택
            restTiles--; // 남은 타일 수 1개 감소
        }

        // 남은 타일을 짝수로 맞추기 위해 2x1 타일과 2x2 타일을 순차적으로 처리
        while (restTiles > 0) {
            // 2x2 타일이 남아 있을 때
            if (bIndex < b && aIndex + 1 < a) {
                // 2x2 타일 하나와 2x1 타일 두 개 중 더 큰 예쁨을 가진 쪽을 선택
                if (bArr[bIndex] > aArr[aIndex] + aArr[aIndex + 1]) {
                    max += bArr[bIndex++];
                } else {
                    max += aArr[aIndex++] + aArr[aIndex++]; // 두 개의 2x1 타일을 선택
                }
            } else if (bIndex < b) {
                // 2x2 타일이 남아 있을 때
                max += bArr[bIndex++];
            } else if (aIndex + 1 < a) {
                // 2x1 타일이 두 개 남아 있을 때
                max += aArr[aIndex++] + aArr[aIndex++];
            } else {
                break; // 더 이상 배치할 타일이 없을 경우 종료
            }
            
            restTiles -= 2; // 두 타일을 사용했으므로 남은 타일 수 감소
        }

        System.out.println(max);
    }
}
