import java.util.*;
import java.io.*;

public class Main {

    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adjList.put(1, Arrays.asList(2,3,5,7));
        for(int i = 2; i < n+1; i++) {
            List<Integer> neighbor = adjList.get(i-1);
            List<Integer> next = adjList.getOrDefault(i, new ArrayList<>());
            int digits = 10;

            for(int j = 0; j < neighbor.size(); j++) {
                for(int k = 0; k < 10; k++) {
                    if(isPrimeNumber(neighbor.get(j) * digits + k)) {
                        next.add(neighbor.get(j) * digits + k);
                    }
                }
            }
            adjList.put(i, next);
        }

        List<Integer> result = adjList.get(n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isPrimeNumber(int number) {
        boolean isPrimeNumber = true;
        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                isPrimeNumber = false;
                break;
            }
        }
        return isPrimeNumber;
    }
}