import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken()); // 진실을 알고있는 인원의 수
        for(int i = 0; i < truthNum; i++) {
            int truthPerson = Integer.parseInt(st.nextToken()) - 1;
            queue.offer(truthPerson); // 진실을 알고 있는 사람을 1로 초기화
            visited[truthPerson] = true;
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        List<int[]> partyList = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int participantsNum = Integer.parseInt(st.nextToken()); // 해당 파티의 참가 인원 수
            int[] partyArr = new int[participantsNum];

            for(int j = 0; j < participantsNum; j++) {
                partyArr[j] = Integer.parseInt(st.nextToken()) - 1;
            }
            partyList.add(partyArr);

            for(int j = 0; j < participantsNum; j++) {
                for(int k = j+1; k < participantsNum; k++) {
                    if(!adjList.get(partyList.get(i)[j]).contains(partyList.get(i)[k])) {
                        adjList.get(partyList.get(i)[j]).add(partyList.get(i)[k]);
                        adjList.get(partyList.get(i)[k]).add(partyList.get(i)[j]);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int i = 0; i < adjList.get(node).size(); i++) {
                if(!visited[adjList.get(node).get(i)]) {
                    visited[adjList.get(node).get(i)] = true;
                    queue.offer(adjList.get(node).get(i));
                }
            }
        }

        int result = m;
        for(int[] partyArr : partyList) {
            boolean check = false;
            for(int i = 0; i < partyArr.length; i++) {
                if(visited[partyArr[i]]) {
                    check = true;
                    break;
                }
            }
            if(check) result--;
        }

        System.out.println(result);
    }
}