import java.util.*;

class Solution {
   public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for(int i = 0; i < callings.length; i++) {
            int rank = map.get(callings[i]);
            String frontPlayer = players[rank - 1];
            
            players[rank - 1] = callings[i];
            map.put(callings[i], rank - 1);
            
            players[rank] = frontPlayer;
            map.put(frontPlayer,rank);
        }
        
        return players;
    }
}