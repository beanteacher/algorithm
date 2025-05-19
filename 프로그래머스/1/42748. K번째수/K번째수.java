import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {

            int[] command = commands[i];

            int start = command[0] - 1;
            int end = command[1];
            int find = command[2] - 1;

            int[] copyArr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(copyArr);
            
            answer[i] = copyArr[find];
        }
        return answer;
    }
}