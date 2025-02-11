package org.algorithm.data.structure.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyGraph {
    static int result = 0;

    static class GraphArray {

        private int[][] array;
        private int[] tmp;

        public GraphArray(int size) {
            array = new int[size+1][size+1];
            tmp = new int[size+1];
        }

        public int[][] getArray() {
            return array;
        }

        public boolean isEmpty() {
            return array.length == 0;
        }

        // 단방향
        public void addDirectedEdge(int x, int y) {
            array[x][y] = 1;
        }

        // 양방향
        public void addCompleteEdge(int x, int y) {
            array[x][y] = 1;
            array[y][x] = 1;
        }

        public void dfs(int start, int n) {
            if(start == n) {
                result++;
                System.out.println("start : " + start + " n : " + n + " result + " + result);
            } else {
                System.out.println("start : " + start + " n : " + n);
                for(int i = 1; i <= n; i++) {

                    if(array[start][i] == 1 && tmp[i] == 0) {
                        tmp[i] = 1;
                        dfs(i, n);
                        tmp[i] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        GraphArray graph = new GraphArray(n);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            graph.addDirectedEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        graph.dfs(1, n);

        System.out.println(result);
    }
}
