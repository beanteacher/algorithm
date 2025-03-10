import java.util.*;

class Solution {
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answers = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                char key = keymap[i].charAt(j); // keymap에서 만들 수 있는 key
                int value = map.getOrDefault(key, 0); // 해당 key를 몇 번 눌러야 만들 수 있는 지에 대한 값
                
                map.put(key, value == 0 ? j+1 : Math.min(value, j+1)); // 해당 key를 만들 수 있는 최솟값을 map에 put
            }
        }

        for(int i = 0; i < targets.length; i++) {
            int answer = 0;
            boolean flag = true;
            
            for(int j = 0; j < targets[i].length(); j++) {
                if(map.containsKey(targets[i].charAt(j))) { // target의 단어를 가진 key를 보유 중이라면
                    answer += map.get(targets[i].charAt(j)); // 최솟값을 answer에 더해준다.
                } else {
                    flag = false;
                    break;
                }
            }
            answers[i] = !flag ? -1 : answer; // answer == 0이면 map에 키가 없는 것이므로 
        }
        return answers;
    }
} 