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

    static class Action {
        int second;
        String direction;

        public Action(int second, String direction) {
            this.second = second;
            this.direction = direction;
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

            arr[column][row] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Queue<Action> actionQueue = new LinkedList<>();

        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            actionQueue.offer(new Action(x, c));
        }

        Queue<Snake> snakeQueue = new LinkedList<>();
        snakeQueue.offer(new Snake(1,1));

        int second = 0;
        int x = 1;
        int y = 1;
        String direction = "RIGHT";

        while (true) {
            second++;

            if(direction.equals("RIGHT")) x++;
            else if(direction.equals("LEFT")) x--;
            else if(direction.equals("UP")) y--;
            else y++;

            // 벽에 부딪힐 경우 종료
            if(x <= 0 || x > n || y <= 0 || y > n) {
                break;
            }

            // 자기 몸에 걸릴 경우 종료
            for(Snake snake : snakeQueue) {
                if(snake.x == x && snake.y == y) {
                    System.out.println(second);
                    return;
                }
            }

            if(arr[x][y] == 1) { // 사과를 만나는 경우 뱀의 몸이 길어졌기 때문에 이 전 위치 제거를 하지 않는다. (꼬리 추가)
                arr[x][y] = 0; // 사과 제거 (중복으로 사과를 먹으면 안되기 때문)
            } else {
                snakeQueue.poll(); // 사과가 없다면 이 전의 위치를 제거 (꼬리 제거)
            }

            // 뱀의 머리 위치 기록
            snakeQueue.offer(new Snake(x, y));

            if(!actionQueue.isEmpty() && actionQueue.peek().second == second) {
                Action action = actionQueue.poll();
                if(action.direction.equals("D")) {
                    if(direction.equals("RIGHT")) direction = "DOWN";
                    else if(direction.equals("LEFT")) direction = "UP";
                    else if(direction.equals("UP")) direction = "RIGHT";
                    else direction = "LEFT";
                } else {
                    if(direction.equals("RIGHT")) direction = "UP";
                    else if(direction.equals("LEFT")) direction = "DOWN";
                    else if(direction.equals("UP")) direction = "LEFT";
                    else direction = "RIGHT";
                }

            }
        }
        System.out.println(second);
    }
}
