import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    static Queue<Node> q = new LinkedList<>();
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map = new int[x][y];
        visit = new boolean[x][y];
        for(int i = 0; i < x; i++) {
            char[] chArr = br.readLine().toCharArray();
            for(int j = 0; j < y; j++) {
                map[i][j] = Character.getNumericValue(chArr[j]);

            }
        }
        bfs(0,0);

        System.out.println(map[x-1][y-1]);
    }

    private static void bfs(int x, int y) {
        q.offer(new Node(x,y));
        visit[x][y] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int i = 0; i < dx.length; i++) {
                try {

                    int cx = node.x + dx[i];
                    int cy = node.y + dy[i];

                    if (map[cx][cy] != 0 && !visit[cx][cy]) {
                        
                        q.offer(new Node(cx, cy));
                        visit[cx][cy] = true;
                        map[cx][cy] = map[node.x][node.y] + 1;
                    }
                } catch (Exception e) {
                    String str = "IndexOutOfBound";
                }
            }
        }
    }
}