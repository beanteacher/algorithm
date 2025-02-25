import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Station station = new Station();
        int target = 0;
        for(int i = 0; i < n; i++) {
            int newCode = Integer.parseInt(st.nextToken());
            station.add(target, newCode);
            
            target = newCode;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int code = Integer.parseInt(st.nextToken());
            int newCode = 0;

            if(command.charAt(0) == 'B') {
                newCode = Integer.parseInt(st.nextToken());
            }

            if(command.equals("BN")) {
                station.print(station.nextArr[code]); // 주어진 역의 다음 역 출력
                station.add(code, newCode); // 주어진 역 다음 역으로 newCode 역 생성
            } else if(command.equals("BP")) {
                station.print(station.preArr[code]); // 주어진 역의 이전 역 출력
                station.add(station.preArr[code], newCode); // 주어진 역 이전 역의 다음 역으로 newCode 역 생성
            } else if(command.equals("CP")) {
                station.print(station.preArr[code]); // 주어진 역의 이전 역 출력
                station.delete(station.preArr[code]); // 주어진 역 이전 역 삭제
            } else {
                station.print(station.nextArr[code]); // 주어진 역의 다음 역 출력
                station.delete(station.nextArr[code]); // 주어진 역 다음 역 삭제
            }
        }
        System.out.println(sb.toString());
    }

    static class Station {
        int[] preArr;
        int[] nextArr;

        public Station() {
            this.preArr = new int[1000001];
            this.nextArr = new int[1000001];
        }

        void add(int existStation, int addStation) {
            if(existStation == 0) {
                preArr[addStation] = nextArr[addStation] = addStation; // 첫 번째 넣을 때는 이전 역과 다음 역 모두 추가 역을 넣는다.
            } else {
                preArr[addStation] = existStation; // 추가 역의 이전 역을 이미 존재하는 역으로
                nextArr[addStation] = nextArr[existStation]; // 추가 역의 다음 역을 이미 존재하는 역의 다음 역으로
                preArr[nextArr[existStation]] = addStation; // 이미 존재하는 역의 다음 역의 이전 역을 추가할 역으로
                nextArr[existStation] = addStation; // 이미 존재하는 역의 다음 역을 추가할 역으로
            }
        }

        void delete(int target) {
            preArr[nextArr[target]] = preArr[target]; // existStation 의 다음 역의 이전 역을 existStation 의 이전 역으로 설정
            nextArr[preArr[target]] = nextArr[target]; // existStation 의 이전 역의 다음 역을 existStation 의 다음 역으로 설정
        }

        void print(int target) {
            sb.append(target).append("\n");
        }
    }
}