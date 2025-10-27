import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][3];

        for (int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            arr[i] = new String[]{inputs[0], inputs[1], inputs[2]};
        }

        Arrays.sort(arr, (o1, o2) -> {
            return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]) ;
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            String temp = String.valueOf(arr[i][0].charAt(Integer.parseInt(arr[i][2])-1));
            sb.append(temp.toUpperCase());
        }

        System.out.println(sb);
    }
}
