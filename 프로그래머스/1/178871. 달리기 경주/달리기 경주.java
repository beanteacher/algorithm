import java.util.*;

class Solution {
   public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i); // key : 선수명, value : 등수
        }

        for(int i = 0; i < callings.length; i++) {
            int rank = map.get(callings[i]); // 호명받은 선수의 등수
            String frontPlayer = players[rank - 1]; // 호명받은 선수보다 앞에 있는 선수
            
            // 앞 선수와 호명받은 선수의 등수를 변경
            players[rank - 1] = callings[i];    // 호명받은 선수의 등수는 현재 등수의 -1
            map.put(callings[i], rank - 1);     // 호명받은 선수의 등수를 map에 저장

            players[rank] = frontPlayer;    // 앞 선수의 등수를 + 1
            map.put(frontPlayer,rank);      // 앞 선수의 등수를 map에 저장
        }

        return players;
   }

   /* 시간초과 코드(Stack 사용) */
   public static String[] solution(String[] players, String[] callings) {
        Stack<String> playerStack = new Stack<>();
        Stack<String> temp = new Stack<>();

        for (String player : players) {
            playerStack.push(player);
        }
        for(int i = 0; i < callings.length; i++) {
            String calling = callings[i];

            while (!playerStack.peek().equals(calling)) {
                temp.push(playerStack.pop());   // 호명 받은 사람보다 낮은 등수에 있는 사람
            }
            calling = playerStack.pop();    // 호명 받은 사람
            String fastenThanMe = playerStack.pop();   // 호명 받은 사람보다 빨랐던 사람
            
            temp.push(fastenThanMe);   
            temp.push(calling);
            while (!temp.isEmpty()) {
                playerStack.push(temp.pop()); // playerStack에 temp라는 Stack에 있는 데이터를 후입선출하여 저장
            }
        }
        return playerStack.toArray(new String[0]);
    }
}
