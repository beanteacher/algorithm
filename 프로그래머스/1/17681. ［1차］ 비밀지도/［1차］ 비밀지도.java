import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String binary1 = Integer.toBinaryString(arr1[i]); // 010001
            String binary2 = Integer.toBinaryString(arr2[i]); // 011100 
            
            while(binary1.length() < n) {
                binary1 = "0" + binary1;
            }
            
            while(binary2.length() < n) {
                binary2 = "0" + binary2;
            }
            
            for(int j = 0; j < n; j++) {
                if(binary1.charAt(j) == '1' || binary2.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}