class Solution {
    static class Xy {
        int maxX;
        int maxY;
        int minX;
        int minY;
        
        public Xy (int maxX, int maxY, int minX, int minY) {
            this.maxX = maxX;
            this.maxY = maxY;
            this.minX = minX;
            this.minY = minY;
        }
    }
    
    public int[] solution(String[] wallpaper) {
        
        Xy xy = null;
        for(int i = 0; i < wallpaper.length; i++) {
            String str = wallpaper[i];
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '#') {
                    if(xy == null) {
                        xy = new Xy(i+1, j+1, i, j);
                    } else {
                        if(xy.minX > i) {
                            xy.minX = i;
                        }
                        if(xy.minY > j) {
                            xy.minY = j;
                        }
                        if(xy.maxX < i+1) {
                            xy.maxX = i+1;
                        } 
                        if(xy.maxY < j+1) {
                            xy.maxY = j+1;
                        }
                    }
                }
            }
        }
        
        int[] answer = {xy.minX, xy.minY, xy.maxX, xy.maxY};
        return answer;
    }
}