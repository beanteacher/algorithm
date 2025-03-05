import java.io.*;
import java.util.*;

public class Main {
    static class Sticker {
        int x;
        int y;
        int area;

        public Sticker(int x, int y) {
            this.x = x;
            this.y = y;
            this.area = x*y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken()); // 모눈종이 높이
        int w = Integer.parseInt(st.nextToken()); // 모눈종이 밑변
        int n = Integer.parseInt(br.readLine()); // 스티커의 개수

        List<Sticker> stickers = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            stickers.add(new Sticker(r,c));
        }

        int result = 0;
        for(int i = 0; i < stickers.size(); i++) {
            Sticker currentSticker = stickers.get(i); // 현재 스티커
            int tempX = h - currentSticker.x; 
            int tempY = w - currentSticker.y; 
            if(tempX >= 0 && tempY >= 0) { // 현재 스티커를 붙일 수 있다면
                for(int j = i+1; j < stickers.size(); j++) {
                    Sticker nextSticker = stickers.get(j);
                    // 남은 공백에 다음 스티커를 붙일 수 있다면
                    if((nextSticker.x <= tempX && nextSticker.y <= w) || (nextSticker.x <= h && nextSticker.y <= tempY)
                            || (nextSticker.y <= tempX && nextSticker.x <= w) || (nextSticker.y <= h && nextSticker.x <= tempY)) {
                        result = Math.max(result, currentSticker.area + nextSticker.area);
                    }
                }
            }
            tempX = h - currentSticker.y;
            tempY = w - currentSticker.x;
            if(tempX >= 0 && tempY >= 0) { // 현재 스티커를 90도 회전해서 붙일 수 있다면
                for(int j = i+1; j < stickers.size(); j++) {
                    Sticker nextSticker = stickers.get(j);
                    // 남은 공백에 다음 스티커를 붙일 수 있다면
                    if((nextSticker.x <= tempX && nextSticker.y <= w) || (nextSticker.x <= h && nextSticker.y <= tempY)
                    || (nextSticker.y <= tempX && nextSticker.x <= w) || (nextSticker.y <= h && nextSticker.x <= tempY)) {
                        result = Math.max(result, currentSticker.area + nextSticker.area);
                    }
                }
            }
        }
        System.out.println(result);
    }
}