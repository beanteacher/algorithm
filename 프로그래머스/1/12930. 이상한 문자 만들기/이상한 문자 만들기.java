class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0;

        for(int i = 0; i < s.length(); i++) {

            if(Character.valueOf(s.charAt(i)).toString().equals(" ")) {
                answer += " ";
                index = 0;
                continue;
            }

            if(index % 2 == 0) {
                answer += Character.valueOf(s.charAt(i)).
                        toString().toUpperCase();
            } else {
                answer +=  Character.valueOf(s.charAt(i)).
                        toString().toLowerCase();
            }
            index++;
        }

        return answer;
    }
}