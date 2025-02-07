import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        // 칠해야되는 곳을 Queue에 보관
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < section.length; i++) {
            queue.offer(section[i]);
        }

        int i = 1;
        // queue에 아무것도 없으면 모두 색칠했으므로 종료
        // i가 n+1보다 커지면 벽을 지나쳤으므로 종료
        while(!queue.isEmpty() && i < n+1) {
            // i가 queue에 있는 값과 같으면
            if(i == queue.peek()) {
                // 연속으로 칠할 수 있는 내역 중 queue에 값이 있으면 제거
                for(int j = 0; j < m; j++) {
                    if(!queue.isEmpty() && i + j == queue.peek()) {
                        queue.poll();
                    }
                }
                // 연속으로 칠한 만큼 i를 증가시킨다.
                i = i + m;
                // 한번 칠했으면 answer 1 증가
                answer++;
            } else {
                // queue에 있는 값이 아니라면 다음 값을 탐색하기 위해 i 1 증가
                i++;
            }
        }

        return answer;
    }
}