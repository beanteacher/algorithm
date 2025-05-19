import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        String change = map.entrySet().stream()
                .filter(entry -> s.contains(entry.getKey()))
                .reduce(s,
                        (result, entry) -> result.replace(entry.getKey(), entry.getValue()),
                        (s1, s2) -> s1);

        int answer = Integer.parseInt(change);

        return answer;
    }
}