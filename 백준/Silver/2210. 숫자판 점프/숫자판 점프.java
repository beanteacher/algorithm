import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr; // 숫자판을 저장할 arr
    static Set<String> set = new HashSet<>(); // 중복되지 않은 값을 담을 set
    
    // 사방으로 움직이기 위한 배열
    static int[] xy1 = {-1, 1, 0, 0};
    static int[] xy2 = {0, 0, 1, -1};
    
    static void dfs(int x, int y, int index, String str) {

        if(index == 5) { // index == 5인 경우는 str의 길이가 6이므로 set에 넣어준다.
            set.add(str);
        } else {
            for(int i = 0; i < 4; i++) { // 현재 위치에서 사방으로 갈 때
                int tempX = x + xy1[i]; 
                int tempY = y + xy2[i];  
                if(tempX >= 0 && tempX < 5 && tempY >= 0 && tempY < 5) { // 사방의 범위가 배열의 범위를 넘어서지 않는 경우
                    dfs(tempX, tempY, index+1, str+arr[tempX][tempY]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); // 숫자판 배열 채우기
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(i,j,0, String.valueOf(arr[i][j])); // dfs 시작 : (0,0)부터 인덱스 0번째 값부터 채워나가기
            }
        }
        
        System.out.println(set.size()); // 중복 값을 허용하지 않는 Set의 크기 출력
    }
}