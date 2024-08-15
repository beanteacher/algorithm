import java.util.HashSet;
import java.util.Set;

class Solution {
     public int solution(int[] nums) {
        int answer = nums.length / 2;

        // N 마리의 폰켓몬 중에서 N/2마리를 선택 시 가장 많은 종류의 폰켓몬을 선택하는 방법
        // 중복이 허용되지 않는 Set을 사용해 Set에 nums[]를 모두 넣고
        // size가 answer의 갯수보다 크면 answer = N/2 이고 그보다 작으면 set의 size가 최대값이다.
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        if(set.size() < answer) answer = set.size();
         
        return answer;
    }
}
