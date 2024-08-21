import java.util.*;
class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < progresses.length; i++) {
            int days = 0;
            int progress = progresses[i];
            while(progress < 100) {
                progress += speeds[i];
                days++;

                if(!deque.isEmpty() && progress >= 100) {
                    while(days < deque.getLast()) {
                        days++;
                    }
                }
            }
            deque.addLast(days);
        }
        System.out.println(deque);

        int day = deque.removeFirst();
        int dayCount = 1;
        Queue<Integer> queue = new LinkedList<>();

        do {
            if(day == deque.getFirst()) {
                dayCount++;
            } else {
                queue.offer(dayCount);
                System.out.println("stack.peek : " + deque.peek() + " + dayCount : " + dayCount);
                dayCount = 1;
            }
            day = deque.removeFirst();
        } while(!deque.isEmpty()); {
            queue.offer(dayCount);
        }
        int[] answer = new int[queue.size()];

        for(int i = 0; i < answer.length; i++) {
            if(!queue.isEmpty()) {
                answer[i] = queue.poll();
            }
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}