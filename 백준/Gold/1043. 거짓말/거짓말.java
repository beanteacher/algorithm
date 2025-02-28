import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>(); // bfs를 위한 queue
        boolean[] visited = new boolean[n]; // 방문 여부를 판단할 visited

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken()); // 진실을 알고있는 인원의 수
        
        for(int i = 0; i < truthNum; i++) {
            int truthPerson = Integer.parseInt(st.nextToken()) - 1;
            queue.offer(truthPerson); // 진실을 알고 있는 사람을 1로 초기화
            visited[truthPerson] = true; // 진실을 아는 사람은 방문 true
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>(); // 인접리스트 구현 
        for(int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        List<int[]> partyList = new ArrayList<>(); // 파티 정보를 담을 List
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int participantsNum = Integer.parseInt(st.nextToken()); // 해당 파티의 참가 인원 수
            int[] partyArr = new int[participantsNum]; // 해당 파티에 참가한 인원을 담을 배열

            for(int j = 0; j < participantsNum; j++) {
                partyArr[j] = Integer.parseInt(st.nextToken()) - 1;
            }
            partyList.add(partyArr); // i번 파티에 참가한 인원들 담기

            for(int j = 0; j < participantsNum; j++) {
                for(int k = j+1; k < participantsNum; k++) {
                    if(!adjList.get(partyList.get(i)[j]).contains(partyList.get(i)[k])) { // i번 파티에 참가한 j와 k 모두에게 무방향 그래프 제공
                        adjList.get(partyList.get(i)[j]).add(partyList.get(i)[k]);
                        adjList.get(partyList.get(i)[k]).add(partyList.get(i)[j]);
                    }
                }
            }
        }

        // bfs 탐색 시작
        while (!queue.isEmpty()) {
            int node = queue.poll(); // queue에서 제거한 인원 -> 진실을 아는 사람
            for(int i = 0; i < adjList.get(node).size(); i++) { // 진실을 아는 사람과 같이 파티를 진행한 사람들을 모두 true로 변경
                if(!visited[adjList.get(node).get(i)]) { 
                    visited[adjList.get(node).get(i)] = true;
                    queue.offer(adjList.get(node).get(i)); // bfs 진행
                }
            }
        }

        int result = m;
        for(int[] partyArr : partyList) {
            boolean check = false;
            for(int i = 0; i < partyArr.length; i++) {
                if(visited[partyArr[i]]) { // 진실을 아는 파티이면 result--를 하기 위해 check를 true로 변경
                    check = true;
                    break;
                }
            }
            if(check) result--;
        }

        System.out.println(result);
    }
}