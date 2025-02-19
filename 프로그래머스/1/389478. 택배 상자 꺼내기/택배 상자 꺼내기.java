import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int height = (n / w) + 1;
        int[][] arr = new int[height][w];
        int count = 1;
        int column = 0;
        int row = 0;
        
        for(int i = 0; i < height; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < w; j++) {
                    if(count > n) break;
                    
                    if(count == num) {
                        column = i;
                        row = j;
                    }
                    
                    arr[i][j] = count++;
                }
                
            } else {
                for(int j = w-1; j >= 0; j--) {
                    if(count > n) break;
                    
                    if(count == num) {
                        column = i;
                        row = j;
                    }
                    
                    arr[i][j] = count++;
                }
            }
        }
        
        for(int i = height - 1; i >= column; i--) {
            if(arr[i][row] != 0) {
                System.out.println(arr[i][row]);
                answer++;
            }
        }
        
        return answer;
    }
}