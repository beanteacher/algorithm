import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken());

        String[] arr = new String[num];
        for(int i = 0; i < num; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, comparator);

        System.out.println(arr[index - 1]);
    }

    public static Comparator<String> comparator = (o1, o2) -> {
        if(o1.length() == o2.length()) {
            return o1.compareTo(o2);
        } else {
            return o1.length() - o2.length();
        }
    };
}