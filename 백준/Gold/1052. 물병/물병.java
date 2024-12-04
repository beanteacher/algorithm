// 물병 하나에는 무한대 L를 담을 수 있다.
// waterBottle < 1,000,000
// notEmptyBottle < 1,000
// 같은 양의 물이 들어있는 물병만 나눠 담을 수 있다.
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int water = Integer.parseInt(st.nextToken()); // 3
    int bottle = Integer.parseInt(st.nextToken()); // 1

    int liter = 1;
    int buy = 0;

    while(bottle != 0) {
      // System.out.println("bottle : " + bottle + " liter : " + liter + " water : " + water);
      if (liter < water) { // 1 < 13 2 < 13 4 < 13 8 < 13
        liter = liter * 2;
      } else if(liter > water) { // 16 > 13
        if(bottle == 1) {
          buy += liter - water; // 8-5 = 3 만큼 더 사야한다.
        } else { // 현재는 bottle = 2
          water -= liter / 2; // 한 개의 bottle에 담기 위해 2로 나눈 값으로 water = 5;

          liter = 1;
        }
        bottle--;
      }

      if (liter == water) {
        bottle--;
      }
    }

    System.out.println(buy);
  }
}