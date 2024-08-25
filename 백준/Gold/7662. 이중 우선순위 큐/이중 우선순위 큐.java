/*
2
7
I 16
I -5643
D -1
D 1
D 1
I 123
D -1
9
I -45
I 653
D 1
I -642
I 45
I 97
D 1
D -1
I 333
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        for(int i = 0; i< repeat; i++) {
            int repeat2 = Integer.parseInt(br.readLine());
            String result;
            TreeMap<Long, Integer> map = new TreeMap<>();

            for(int j = 0; j < repeat2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String insertOrDelete = st.nextToken();
                long num = Long.parseLong(st.nextToken());
                if(insertOrDelete.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if(!map.isEmpty()) {
                        if(num > 0) {
                            if(map.get(map.lastKey()) > 1) {
                                map.put(map.lastKey(), map.get(map.lastKey()) -1);
                            } else {
                                map.remove(map.lastKey());
                            }
                        } else {
                            if(map.get(map.firstKey()) > 1) {
                                map.put(map.firstKey(), map.get(map.firstKey()) -1);
                            } else {
                                map.remove(map.firstKey());
                            }
                        }
                    }
                }
            }
            if(!map.isEmpty()) {
                result = map.lastKey() + " " + map.firstKey();
            } else {
                result = "EMPTY";
            }
            System.out.println(result);
        }
    }
 }