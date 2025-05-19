import java.util.*;

class Solution {
    public String solution(int[] food) {
        
        int[] count = new int[food.length];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            count[i] = food[i] / 2;
            
            if(count[i] > 0) {
                for(int j = 0; j < count[i]; j++) {
                    sb.append(i);
                }
            }
        }
        
        sb.append(0);
        
        for(int i = count.length - 1; i >= 1; i--) {
            for(int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}