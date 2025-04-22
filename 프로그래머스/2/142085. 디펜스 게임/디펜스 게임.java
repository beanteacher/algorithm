import java.util.*;

class Solution {
    static class Enemy implements Comparable<Enemy> {
        int round;
        int enemyCount;

        public Enemy(int round, int enemyCount) {
            this.round = round;
            this.enemyCount = enemyCount;
        }

        @Override
        public int compareTo(Enemy enemy) {
            return this.enemyCount - enemy.enemyCount;
        }
    }

    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Enemy> pq = new PriorityQueue<Enemy>(); // 적의 수를 기준으로 오름차순 정렬
        for(int i = 0; i < enemy.length; i++) { // 1,000,000
            pq.offer(new Enemy(i+1, enemy[i]));
        }

        int answer = 0;


        // answer를 변경하는 기준은 현재 answer보다 크면 변경해준다.
        while(!pq.isEmpty()) { // 1,000,000
            Enemy e = pq.poll(); // 가장 적의 수가 적은 라운드부터 처리
            boolean isOk = true;
            if(e.round > k) { // 가장 적의 수가 적은 라운드가 k(무적권)보다 크면
                // 해당 라운드까지 배열을 복사한 뒤 역순 정렬한 다음 가장 큰 순으로 무적권을 사용한 뒤 남은 수의 합이 n 이하면 가능한 라운드로 answer를 변경해준다. -> 시간 초과할 가능성 농후
                int[] copyArr = Arrays.copyOf(enemy, e.round);
                Arrays.sort(copyArr);

                int totalEnemyCount = 0;
                for(int i = copyArr.length - 1 - k; i >= 0; i--) {
                    totalEnemyCount += copyArr[i];
                    // System.out.println("i : " + i);
                    if(totalEnemyCount > n) {
                        isOk = false;
                        // System.out.println("@@@");
                        break;
                    }
                }
            }
            // 위의 조건을 충족하거나 가장 적의 수가 적은 라운드가 k보다 작거나 같으면 여기까진 무조건 가능하므로 answer를 변경
            if(isOk) answer = Math.max(e.round, answer);
        }

        // System.out.println(answer);
        return answer;
    }
}