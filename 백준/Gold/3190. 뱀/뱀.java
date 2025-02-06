import java.util.*;
import java.io.*;

public class Main {
    static class Snake {
        int x;
        int y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];

        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());

            arr[row][column] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Map<Integer, String> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            queue.offer(second);
            map.put(second, dir);
        }

        int time = 0;
        int x = 1;
        int y = 1;

        Queue<Snake> snakeQueue = new LinkedList<>();
        snakeQueue.offer(new Snake(1,1));

        String direct = "RIGHT";
        while(true) {
            time++;

            if(direct.equals("RIGHT")) y++;
            else if(direct.equals("LEFT")) y--;
            else if(direct.equals("UP")) x--;
            else x++;

            if(x <= 0 || x > n || y <= 0 || y > n) {
                break;
            }

            for (Snake s : snakeQueue) {
                if (s.x == x && s.y == y) { // 현재 이동한 머리와 몸이 겹치는 경우

                    System.out.println(time);
                    return;
                }
            }

            // 사과를 만나지 않으면 이 전 칸의 뱀은 이동했으므로 뱀의 위치에서 삭제
            if(arr[x][y] == 1) { // 사과를 만나면 사과 삭제
                arr[x][y] = 0;
            } else {
                snakeQueue.poll();
            }

            snakeQueue.offer(new Snake(x, y));

            if(!queue.isEmpty() && time == queue.peek()) {
                String dir = map.get(queue.poll());

                if(dir.equals("L")) {
                    if(direct.equals("RIGHT")) direct = "UP";
                    else if(direct.equals("LEFT")) direct = "DOWN";
                    else if(direct.equals("UP")) direct = "LEFT";
                    else direct = "RIGHT";
                } else {
                    if(direct.equals("RIGHT")) direct = "DOWN";
                    else if(direct.equals("LEFT")) direct = "UP";
                    else if(direct.equals("UP")) direct = "RIGHT";
                    else direct = "LEFT";
                }
            }

        }
        System.out.println(time);
    }
}