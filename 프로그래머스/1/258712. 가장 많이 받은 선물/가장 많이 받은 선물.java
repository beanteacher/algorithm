import java.util.HashMap;
import java.util.Map;

class Solution {
   public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> scoreMap = new HashMap<>();
        Map<String, Map<String, Integer>> presentMap = new HashMap<>();

        for(String giveFriend : friends) {
            scoreMap.put(giveFriend, 0);  // scoreMap에 friend라는 키 값 초기화
            for(String takeFriend : friends) {
                if(giveFriend.equals(takeFriend)) continue;

                presentMap.putIfAbsent(giveFriend, new HashMap<>());
                // 값이 존재하면 value 를 반환, 존재하지 않으면 value 에 null 을 대입
                presentMap.get(giveFriend).put(takeFriend, 0); // presentMap 에 friend1이라는 키의 friend2라는 키 값 초기화
            }
        }
        for(String gift : gifts) {

            String[] giftArr = gift.split(" ");

            String giver = giftArr[0];
            String taker = giftArr[1];
            presentMap.get(giver).put(taker, presentMap.get(giver).get(taker) + 1);

            // 각각 준 사람과 받은 사람의 선물 지수 +- 작업
            scoreMap.put(giver, scoreMap.get(giver) + 1);
            scoreMap.put(taker, scoreMap.get(taker) - 1);
        }
        System.out.println(presentMap);
        System.out.println(scoreMap);

        Map<String, Integer> countMap = new HashMap<>();

        for(String giveFriend : friends) {
            countMap.put(giveFriend, 0);
            for (String takeFriend : friends) {
                if(giveFriend.equals(takeFriend)) continue;
                int giveCount = presentMap.get(giveFriend).get(takeFriend);
                int takeCount = presentMap.get(takeFriend).get(giveFriend);
                if(giveCount > takeCount) {
                    countMap.put(giveFriend, countMap.get(giveFriend) + 1);
                } else if(giveCount == takeCount) {
                    if(scoreMap.get(giveFriend) > scoreMap.get(takeFriend)) countMap.put(giveFriend, countMap.get(giveFriend) + 1);
                }
            }
            if(countMap.get(giveFriend) > answer) answer = countMap.get(giveFriend);
        }

        return answer;
    }
}