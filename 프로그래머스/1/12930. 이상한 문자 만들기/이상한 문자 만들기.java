class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0;

        for(int i = 0; i < s.length(); i++) {
            if(index % 2 == 0) {  // index가 짝수 -> 대문자로 변경
                answer += Character.valueOf(s.charAt(i)).
                        toString().toUpperCase();
            } else { // index가 홀수 -> 소문자로 변경
                answer +=  Character.valueOf(s.charAt(i)).
                        toString().toLowerCase();
            }
            
            if(Character.valueOf(s.charAt(i)).toString().equals(" ")) { // 띄워쓰기가 나오면 index 0으로 초기화
                index = 0;
                continue;
            }
            index++;
        }

        return answer;
    }
}
