
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int result = 0;
            List<XY> xyList = new ArrayList<>();

            for(int j = 0; j < 4; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                xyList.add(new XY(x,y));
            }

            xyList.sort(new Comparator<XY>() {
                @Override
                public int compare(XY o1, XY o2) {
                    if (o1.x != o2.x) {
                        return o2.x - o1.x;
                    } else {
                        return o2.y - o1.y;
                    }
                }
            });

            int x1 = xyList.get(0).x;
            int x2 = xyList.get(1).x;
            int x3 = xyList.get(2).x;
            int x4 = xyList.get(3).x;

            int y1 = xyList.get(0).y;
            int y2 = xyList.get(1).y;
            int y3 = xyList.get(2).y;
            int y4 = xyList.get(3).y;

            int length = (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1);
            result = length == (x4 - x2)*(x4 - x2) + (y4 - y2)*(y4 - y2) &&
                    length == (x4 - x3)*(x4 - x3) + (y4 - y3)*(y4 - y3) &&
                    length == (x3 - x1)*(x3 - x1) + (y3 - y1)*(y3 - y1) ? 1 : 0;

            if(result == 0) {
                System.out.println(result);
            } else {
                length = (x4 - x1)*(x4 - x1) + (y4 - y1)*(y4 - y1);
                result = length == (x3 - x2)*(x3 - x2) + (y3 - y2)*(y3 - y2) ? 1 : 0;
                
                System.out.println(result);
            }
        }
    }

    static class XY {
        public int x;
        public int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}