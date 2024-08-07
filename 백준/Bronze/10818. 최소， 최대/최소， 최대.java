//N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int num = scanner.nextInt();
        
        int max = num;
        int min = num;
        
        for(int i = 0; i < count - 1; i++) {
            num = scanner.nextInt();
            if(num < min) {
                min = num;
            }
            if(num > max) {
                max = num;
            }
        }
        System.out.println(min + " " + max);
    }
}