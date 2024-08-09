class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String check = board[h][w];
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        
            for(int i = 0; i < dh.length; i++) {
                try {
                    if(check.equals(board[h-dh[i]][w-dw[i]])) answer++;
                } catch(Exception e) {
            
                }          
            }
        
        
        
        return answer;
    }
}