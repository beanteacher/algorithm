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
                // IndexOutOfException 발생 시 배열이 존재하지 않기 때문에 answer 증가X
            }          
        }
        
        return answer;
    }
}
