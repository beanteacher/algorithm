import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < section.length; i++) {
            queue.offer(section[i]);
        }

        int i = 1;
        while(!queue.isEmpty() && i < n+1) {
            if(i == queue.peek()) {
                for(int j = 0; j < m; j++) {
                    if(!queue.isEmpty() && i + j == queue.peek()) {
                        queue.poll();
                    }
                }
                i = i + m;
                answer++;
            } else {
                i++;
            }
        }

        return answer;
    }
}