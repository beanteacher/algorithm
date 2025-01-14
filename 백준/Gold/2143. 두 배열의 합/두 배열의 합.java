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

        Collections.sort(nArrSubList);
        Collections.sort(mArrSubList);

        System.out.println(twoPointer(nArrSubList, mArrSubList, t));
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

    public static long twoPointer(List<Integer> nSubList, List<Integer> mSubList, int t) {
        int nCount = 0;
        int mCount = mSubList.size() - 1;
        long result = 0;

        while (nCount < nSubList.size() && mCount >= 0) {
            int nValue = nSubList.get(nCount);
            int mValue = mSubList.get(mCount);
            int sum = nValue + mValue;
            if(sum == t) {
                long nResult = 0;
                long mResult = 0;

                while(nCount < nSubList.size() && nValue == nSubList.get(nCount)) { // 같은 값이 몇 번 반복되는 지
                    nResult++;
                    nCount++;
                }

                while(mCount >= 0 && mValue == mSubList.get(mCount)) { // 같은 값이 몇 번 반복되는 지
                    mResult++;
                    mCount--;
                }

                result += nResult * mResult;

            } else if(sum > t)  { // t보다 크면 줄여야하므로 mCount를 감소시킨다.
                mCount--;
            } else { // t보다 작으면 더 키워야하므로 nCount를 증가시킨다.
                nCount++;
            }
        }

        return result;
    }
}