import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int size = 0;
        String str;

        while((str = br.readLine()) != null) {

            if(map.getOrDefault(str, 0) == 0) {
                list.add(str);
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
            size++;
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(String tree : list) {
            int count = map.get(tree) * 100;
            sb.append(tree).append(" ").append(String.format("%.4f", (double) count / (double) size)).append("\n");
        }
        System.out.println(sb);
    }
}