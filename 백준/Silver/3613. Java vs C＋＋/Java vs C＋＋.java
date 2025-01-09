import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] words = word.toCharArray();
        StringBuilder result = new StringBuilder();

        boolean isError = false;

        if(!Character.isLowerCase(word.charAt(0)) // 첫글자가 소문자가 아닌 경우 에러
                || word.charAt(word.length() - 1) == '_' // 마지막 문자가 _인 경우 에러
                || (word.contains("_") && word.chars().anyMatch(Character::isUpperCase))) { // _도 있고 대문자도 있는 경우 에러

            System.out.println("Error!");
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(words[i] == '_') {
                char nextWord = words[++i];

                if(nextWord == '_') {
                    isError = true;
                    break;
                } else {
                    result.append(Character.toUpperCase(nextWord));
                }
            } else if(Character.isUpperCase(words[i])) {
                result.append("_").append(Character.toLowerCase(words[i]));
            } else if(Character.isLowerCase(words[i])){
                result.append(words[i]);
            } else {
                isError = true;
                break;
            }
        }

        System.out.println(isError ? "Error!" : result);
    }
}