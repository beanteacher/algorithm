import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int size = 0;
        String str;

        // 입력이 null이 들어오지 않을 때까지 반복
        while((str = br.readLine()) != null) {
            if(map.getOrDefault(str, 0) == 0) {
                list.add(str); // 사전 순으로 정렬을 하기 위해 처음 들어온 나무는 list에 넣어준다.
            }
            // map에 나무의 이름과 나무의 개수를 저장한다.
            map.put(str, map.getOrDefault(str, 0) + 1);
            // 전체 개수를 저장한다.
            size++;
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(String tree : list) {
            // 백분율로 만들기 위해 100을 곱해준다.
            int count = map.get(tree) * 100;
            // 소숫점 4번 째 자리까지 표현하기 위해 String.format("%.4f", double)를 사용한다.
            sb.append(tree).append(" ").append(String.format("%.4f", (double) count / (double) size)).append("\n");
        }
        System.out.println(sb);
    }
}