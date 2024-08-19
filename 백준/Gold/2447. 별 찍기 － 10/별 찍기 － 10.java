import java.io.*;

public class Main {
    static String[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        arr = new String[size][size];
        star(0, 0, size, false);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void star(int x, int y, int size, boolean blank) {

        if(blank) {
            for(int i = x; i < x+size; i++) {
                for(int j = y; j < y+size; j++) {
                    arr[i][j] = " ";
                }
            }
            return;
        }

        if(size == 1) {
            arr[x][y] = "*";
            return;
        }

        int recursionSize = size / 3;
        int count = 0;

        for(int i = x; i < x+size; i += recursionSize) {
            for(int j = y; j < y+size; j += recursionSize) {
                count++;

                star(i,j,recursionSize,count==5);
            }
        }
    }
}
