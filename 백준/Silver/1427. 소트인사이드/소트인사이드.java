import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = new int[str.length()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }
        selectSort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }

    static void selectSort(int[] arr) {

        for(int i = 0; i < arr.length; i++) {
            int max = -1;
            int maxIndex = -1;

            for(int j = i; j < arr.length; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            arr[maxIndex] = arr[i];
            arr[i] = max;
        }
    }
}