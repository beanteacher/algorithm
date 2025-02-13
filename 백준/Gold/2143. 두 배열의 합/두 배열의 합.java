import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        // n의 부분 합을 담아주기 위해 nList에 n의 부분 합을 저장한다.
        List<Integer> nList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nArr[j];

                nList.add(sum);
            }
        }

        // m의 부분 합을 담아주기 위해 mList에 m의 부분 합을 저장한다.
        List<Integer> mList = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = i; j < m; j++) {
                sum += mArr[j];

                mList.add(sum);
            }
        }
        // 투 포인터를 위해 정렬
        Collections.sort(nList);
        Collections.sort(mList);

        int i = 0;
        int j = mList.size() - 1;

        long result = 0;
        while(i < nList.size() && j >= 0) {
            int nNum = nList.get(i);
            int mNum = mList.get(j);

            int sum = nNum + mNum;
            // 두 부분 합이 t와 같은 경우
            if(sum == t) {

                long nCount = 0;
                long mCount = 0;
                // n의 부분 합에서 nNum과 같은 값의 개수를 체크
                while(i < nList.size() && nNum == nList.get(i)) {
                    nCount++;
                    i++;
                }

                // m의 부분 합에서 mNum과 같은 값의 개수를 체크
                while(j >= 0 && mNum == mList.get(j)) {
                    mCount++;
                    j--;
                }

                // n의 부분 합의 개수 * m의 부분 합의 개수
                result += nCount * mCount;
            } else if(sum > t) { // 두 부분 합의 합이 T보다 크면 더 작은 값을 찾기 위해 j--
                j--;
            } else { // 두 부분 합의 합이 T보다 작으면 더 큰 값을 찾기 위해 i++
                i++;
            }
        }

        System.out.println(result);
    }
}