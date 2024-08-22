import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Balloon> deque = new ArrayDeque<>();
        for(int i = 0; i < count; i++) {
            deque.addLast(new Balloon(i+1, Integer.parseInt(st.nextToken())));
        }

        Balloon ballon = deque.removeFirst();
        int removeValue = ballon.value;
        StringBuilder result = new StringBuilder().append(ballon.index).append(" ");

        while(!deque.isEmpty()) {
            if (removeValue > 0) {
                for (int j = 1; j < removeValue; j++) {
                    deque.addLast(deque.removeFirst());
                }

                ballon = deque.removeFirst();
                removeValue = ballon.value;
                result.append(ballon.index).append(" ");
            } else {
                for (int j = 1; j < Math.abs(removeValue); j++) {
                    deque.addFirst(deque.removeLast());
                }

                ballon = deque.removeLast();
                removeValue = ballon.value;
                result.append(ballon.index).append(" ");
            }
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
}

class Balloon {
    int index;
    int value;

    public Balloon(int index, int value) {
        this.index = index;
        this.value = value;
    }
}