import java.util.*;
class Solution {
    
    public static int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < progresses.length; i++) {
            int days = 0;   //프로세스를 완성하기까지 얼마나 걸렸는 지 저장할 days
            int progress = progresses[i];   //현재 프로세스 완료량 (95퍼)
            do {
                progress += speeds[i];  //프로세스에 하루 당 프로세스 진행량을 더한다. -> 1일차 (96%) 2일차 (97%) ...
                days++; // 1일차, 2일차 ...

                if(!deque.isEmpty() && progress >= 100) {   // 첫 번째 프로세스는 deque가 비어있으므로 생략
                    // 현재 프로세스가 완료되었지만 이전 프로세스의 기간보다 적게 걸려 이전 프로세스와 함께 배포해야하므로 days만 증가
                    // days가 이전 프로세스의 종료기간과 같아질 때까지 진행
                    while(days < deque.getLast()) {
                        days++;
                    }
                }
            } while(progress < 100); // 프로세스가 100% 이상이 되면 종료

            deque.addLast(days); // 프로세스 종료 시 종료까지 걸린 날짜 deque에 맨 뒤에 넣기
        }

        int day = deque.removeFirst(); // 가장 먼저 프로세스 종료된 날짜
        int releaseCount = 1; // 배포할 프로세스의 개수 (프로젝트는 1개 이상 배포하므로 1로 초기화)
        Queue<Integer> queue = new LinkedList<>();  // 프로세스의 개수를 담을 큐 선언

        do {
            // 가장 먼저 종료된 프로세스와 같은 날에 종료된 프로세스가 있다면 함께 배포할 프로세스이므로 배포할 프로세스의 개수 증가
            if(day == deque.getFirst()) {   // getFirst()는 삭제하지 않고 가장 첫 번째 요소를 가져온다.
                releaseCount++;
            } else {
                // 같이 배포할 프로세스가 아니라면 큐에 담고 배포할 프로세스 수 1로 초기화
                queue.offer(releaseCount);
                releaseCount = 1;
            }
            day = deque.removeFirst();  // 다음 배포할 프로세스들을 deque에서 삭제
        } while(!deque.isEmpty()); {
            queue.offer(releaseCount);  // 마지막 배포할 프로세스의 개수를 queue에 저장
        }
        int[] answer = new int[queue.size()];

        for(int i = 0; i < answer.length; i++) {
            if(!queue.isEmpty()) {
                answer[i] = queue.poll();
            }
        }

        return answer;
    }
}
