class Solution {
    static boolean solution(String s) {
        boolean answer = false;
        String[] sarr = s.split("");
        int leftCount = 0;
        int rightCount = 0;
        for(int i = 0; i < sarr.length; i++) {

            if(sarr[i].equals("(")) leftCount++;
            else if(sarr[i].equals(")")) rightCount++;
            if(rightCount > leftCount) return false;
        }

        if(leftCount == rightCount) return true;

        return answer;
    }
}