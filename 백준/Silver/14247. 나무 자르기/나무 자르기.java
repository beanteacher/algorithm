import java.util.*;
import java.io.*;

public class Main {
    static class Tree implements Comparable<Tree> {
        long length;
        long grow;

        public Tree(long length) {
            this.length = length;
        }

        public void setGrow(long grow) {
            this.grow = grow;
        }

        @Override
        public int compareTo(Tree tree) {
            return (int) (grow - tree.grow);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Tree[] treeArr = new Tree[n];
        for(int i = 0; i < n; i++) {
            treeArr[i] = new Tree(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            treeArr[i].setGrow(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(treeArr);

        long result = 0;
        for(int i = 0; i < n; i++) {
            result += treeArr[i].length + (i * treeArr[i].grow);
        }

        System.out.println(result);
    }
}