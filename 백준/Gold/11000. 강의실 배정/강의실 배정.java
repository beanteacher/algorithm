import java.io.*;
import java.util.*;

public class Main {
    static class StartClassRoom implements Comparable<StartClassRoom> {
        int startTime;
        int endTime;

        public StartClassRoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(StartClassRoom classRoom) {
            return startTime - classRoom.startTime;
        }
    }

    static class EndClassRoom implements Comparable<EndClassRoom> {
        int startTime;
        int endTime;

        public EndClassRoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(EndClassRoom classRoom) {
            return endTime - classRoom.endTime;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<StartClassRoom> startClassRooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            startClassRooms.offer(new StartClassRoom(startTime, endTime));
        }

        int result = 1;
        int time = 0;

        PriorityQueue<EndClassRoom> endClassRooms = new PriorityQueue<>();
        while(!startClassRooms.isEmpty()) {
            int startClassTime = startClassRooms.peek().startTime;
            int endClassTime = endClassRooms.isEmpty() ? Integer.MAX_VALUE: endClassRooms.peek().endTime;

            if(startClassTime < endClassTime) { // 시작 시간이 종료 시간보다 더 작다는 의미는 시작할 때가 됐다는 의미
                StartClassRoom classRoom = startClassRooms.poll(); // 수업 시작을 했다는 의미를 위해 startClassRooms에서 제거

                endClassRooms.offer(new EndClassRoom(classRoom.startTime, classRoom.endTime)); // 수업을 시작을 했다는 의미를 위해 endClassRooms에 수업 추가

                result = Math.max(result, endClassRooms.size());
            } else { // 종료 시간이 더 작다는 의미는 종료할 때가 됐다는 의미
                endClassRooms.poll(); // 종료됐다는 의미는 endClassRooms에서 수업을 제거해준다.
            }
        }

        System.out.println(result);
    }
}
