import java.util.*;

class Solution {
    
    public int solution(int[] nums) {
        
        int N = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        
        return set.size() > N ? N : set.size();
    }
}