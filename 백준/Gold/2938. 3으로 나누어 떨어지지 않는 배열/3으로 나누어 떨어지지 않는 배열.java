import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 나머지가 1과 2가 붙으면 안되고 나머지가 0인 것들끼리 붙으면 안된다.
        Queue<Integer> zero = new LinkedList<>();
        Queue<Integer> one = new LinkedList<>();
        Queue<Integer> two = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num % 3 == 0) zero.offer(num);
            else if (num % 3 == 1) one.offer(num);
            else two.offer(num);
        }
        // 나머지가 0인 경우가 전체의 절반 이상이면 불가능
        // 나머지가 0이 없는데 1과 2만 있다면 불가능
        if(zero.size() > (n+1) / 2 || (zero.isEmpty() && !one.isEmpty() && !two.isEmpty())) {
            System.out.println(-1);

            return;
        }

        List<Integer> result = new ArrayList<>();
        // 나머지가 1인 큐를 비울 때까지 zero와 one에서 섞어서 result에 담아준다.
        while(!one.isEmpty()) {
            // 나머지가 1인 것과 2인 것을 분리하기 위해 나머지가 0인 것은 하나 이상은 남아야하기 때문에
            if(zero.size() > 1) result.add(zero.poll());
            result.add(one.poll());
        }

        // 나머지가 1인 것과 2인 것을 분리하기 위해 나머지가 0인 것을 추가
        if(!zero.isEmpty()) {
            result.add(zero.poll());
        }

        // 나머지가 2인 큐를 비울 때까지 two와 zero에서 섞어서 result에 담아준다.
        while(!two.isEmpty()) {
            result.add(two.poll());
            if(!zero.isEmpty()) result.add(zero.poll());
        }

        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}