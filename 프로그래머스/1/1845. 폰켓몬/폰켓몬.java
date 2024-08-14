import java.util.HashSet;
import java.util.Set;

class Solution {
     public int solution(int[] nums) {
        int answer = 0;
        int count =  nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        if(set.size() >= count) answer = count;
        else answer = set.size();
         
        return answer;
    }
}