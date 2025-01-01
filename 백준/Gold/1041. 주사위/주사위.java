import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] abcdef = new int[6];
        for(int i = 0; i < 6; i++) {
            abcdef[i] = Integer.parseInt(st.nextToken());
        }

        int twoMin = 0;

        int ab = abcdef[0] + abcdef[1];
        int ac = abcdef[0] + abcdef[2];
        int ad = abcdef[0] + abcdef[3];
        int ae = abcdef[0] + abcdef[4];
        int bc = abcdef[1] + abcdef[2];
        int bd = abcdef[1] + abcdef[3];
        int bf = abcdef[1] + abcdef[5];
        int ce = abcdef[2] + abcdef[4];
        int cf = abcdef[2] + abcdef[5];
        int de = abcdef[3] + abcdef[4];
        int df = abcdef[3] + abcdef[5];
        int ef = abcdef[4] + abcdef[5];

        twoMin = Math.min(twoMin, ab);
        twoMin = Math.min(twoMin, ac);
        twoMin = Math.min(twoMin, ad);
        twoMin = Math.min(twoMin, ae);
        twoMin = Math.min(twoMin, bc);
        twoMin = Math.min(twoMin, bd);
        twoMin = Math.min(twoMin, bf);
        twoMin = Math.min(twoMin, ce);
        twoMin = Math.min(twoMin, cf);
        twoMin = Math.min(twoMin, de);
        twoMin = Math.min(twoMin, df);
        twoMin = Math.min(twoMin, ef);

        Arrays.sort(abcdef);
        int oneMin = abcdef[0];
        int threeMin = abcdef[0]+abcdef[1]+abcdef[2];

        int result = 0;
        result += 4*threeMin;
        // result += (4*(n-2) + 4*(n-1))*twoMin;
        result += (8*(n-2) + 4)*twoMin;
        // result += ((n-2)*(n-2) + 4*(n-2)*(n-1))*oneMin;
        result += (5*(n-2)^2 + 4*(n-2))*oneMin;
        System.out.println(result);
    }
}
