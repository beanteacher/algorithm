/*
2 1 -> (보석의 개수 2, 가방의 개수 1) 
5 10 (보석의 무게 5, 보석의 가격 10)
100 100 (보석의 무게 100, 보석의 가격 100)
11 (가방 별 최대 무게 11)
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String crystalBagCount = br.readLine();
        int crystalCount = Integer.parseInt(crystalBagCount.split(" ")[0]);
        int bagCount = Integer.parseInt(crystalBagCount.split(" ")[1]);

        int[][] crystalArr = new int[crystalCount][2];
        for(int i = 0; i < crystalCount; i++) {
            String crystalInfo = br.readLine();
            int crystalWeight = Integer.parseInt(crystalInfo.split(" ")[0]);
            int crystalPrice = Integer.parseInt(crystalInfo.split(" ")[1]);
            crystalArr[i][0] = crystalWeight;
            crystalArr[i][1] = crystalPrice;
        }

        int crystalWeightSum = 0;

        for(int i = 0; i < bagCount; i++) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
            int bagMaxWeight = Integer.parseInt(br.readLine());
            
            for(int j = 0; j < crystalArr.length; j++) {
                if(bagMaxWeight > crystalArr[j][0]) {
                    maxHeap.offer(crystalArr[j][1]);
                }
            }

            if(!maxHeap.isEmpty()) {
                crystalWeightSum += maxHeap.poll();
            }
        }

        System.out.println(crystalWeightSum);
    }
}
