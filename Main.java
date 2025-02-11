import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nArr = new int[n];
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] mArr = new int[m];
        for(int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> nArrSubList = subListSum(nArr);
        List<Integer> mArrSubList = subListSum(mArr);

        Collections.sort(mArrSubList);

        int result = 0;
        for(int i = 0; i < nArrSubList.size(); i++) {
            int minus = t - nArrSubList.get(i);

            result += twoPointer(minus, mArrSubList);
        }
        System.out.println(result);
    }

    public static List<Integer> subListSum(int[] arr) {

        List<Integer> subList = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            int sum = 0;

            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
                subList.add(sum);
            }
        }

        return subList;
    }

    public static int twoPointer(int minus, List<Integer> subList) {
        int result = 0;

        for(int i = 0; i < subList.size(); i++) {
            if(minus == subList.get(i)) {
                result++;
            }
        }
        return result;
    }
}