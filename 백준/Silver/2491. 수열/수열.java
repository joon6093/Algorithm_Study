import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] inputs = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        int max = 1;
        int isUp = 1;
        int isDown = 1;
        for(int i=1; i<N; i++) {
            int prev = arr[i-1];
            int current = arr[i];

            if(current > prev) {
                isUp++;
                isDown = 1;
            } else if(current < prev) {
                isDown++;
                isUp = 1;
            } else {
                isUp++;
                isDown++;
            }

            max = Math.max(max,  Math.max(isUp, isDown));
            prev = arr[i];
        }

        System.out.println(max);
    }
}
