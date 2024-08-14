public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> scoreMap = new HashMap<>();
        Map<String, Map<String, Integer>> presentMap = new HashMap<>();

        for(String giveFriend : friends) {
            scoreMap.put(giveFriend, 0);  // scoreMap 선물 지수(선물을 받아야 할 순위)를 0으로 초기화
            for(String takeFriend : friends) {
                if(giveFriend.equals(takeFriend)) continue;

                /* 선물을 준 사람 Map 을 Null 로 초기화  
                * putIfAbsent() : 값이 존재하면 value 를 반환, 존재하지 않으면 value 에 null 을 대입*/
                presentMap.putIfAbsent(giveFriend, new HashMap<>());
                presentMap.get(giveFriend).put(takeFriend, 0); // presentMap 에 선물을 준 사람이 친구들에게 선물을 준 수를 0으로 초기화
            }
        }
        for(String gift : gifts) {

            String[] giftArr = gift.split(" ");

            String giver = giftArr[0];
            String taker = giftArr[1];
            /* 선물을 준 사람의 Map 에 선물을 받은 사람의 Key 에 값을 선물을 받을 때마다 하나씩 증가*/
            presentMap.get(giver).put(taker, presentMap.get(giver).get(taker) + 1);

            // 선물을 준 사람은 선물 지수(선물을 받아야 할 순위) 상승
            // 선물을 받은 사람은 선물 지수(선물을 받아야 할 순위) 하락
            scoreMap.put(giver, scoreMap.get(giver) + 1);
            scoreMap.put(taker, scoreMap.get(taker) - 1);
        }

        /* 선물 개수를 담을 Map 선언 */
        Map<String, Integer> countMap = new HashMap<>();    

        for(String giveFriend : friends) {
            /* 선물 개수를 0으로 초기화 (하지않으면 nullPointException 발생)*/
            countMap.put(giveFriend, 0);
            for (String takeFriend : friends) {
                /* 주는 사람과 받는 사람이 같은 반복은 제외 */
                if(giveFriend.equals(takeFriend)) continue;
                /* 끼리끼리 주고받은 선물 개수 비교를 위해 giveCount 와 takeCount 를 설정   */
                int giveCount = presentMap.get(giveFriend).get(takeFriend);
                int takeCount = presentMap.get(takeFriend).get(giveFriend);
                if(giveCount > takeCount) {
                    /* 선물지수가 높은(선물을 더 많이 준 사람)이 선물을 하나 더 받는다. */
                    countMap.put(giveFriend, countMap.get(giveFriend) + 1);
                } else if(giveCount == takeCount) {
                    /* 주고 받은 선물의 수가 같으면 선물지수가 높은 사람이 선물을 하나 더 받는다. */
                    if(scoreMap.get(giveFriend) > scoreMap.get(takeFriend)) countMap.put(giveFriend, countMap.get(giveFriend) + 1);
                }
            }
            /* 최대 값을 가져오기 위한 작업*/
            if(countMap.get(giveFriend) > answer) answer = countMap.get(giveFriend);
        }

        return answer;
    }
