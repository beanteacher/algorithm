import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] nArr = new String[n];
        for(int i = 0; i < n; i++) {
            nArr[i] = br.readLine();
        }
        Arrays.sort(nArr);

        String[] mArr = new String[m];
        for(int i = 0; i < m; i++) {
            mArr[i] = br.readLine();
        }
        Arrays.sort(mArr);

        int nCount = 0;
        int mCount = 0;

        List<String> acquaintanceList = new ArrayList<>();

        while(nCount < n) {
            if(nArr[nCount].equals(mArr[mCount])) {
                acquaintanceList.add(nArr[nCount]);
                nCount++;
                mCount = 0;
            } else {
                mCount++;
            }

            if(mCount == m) {
                nCount++;
                mCount = 0;
            }
        }

        if(acquaintanceList.isEmpty()) {
            System.out.println(-1);
        } else {

            Collections.sort(acquaintanceList);

            for(String acquaintance : acquaintanceList) System.out.println(acquaintance);
        }
    }
}