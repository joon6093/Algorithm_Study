import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int load = (N + M) * 2;
        int S = Integer.parseInt(br.readLine());
        int[] store = new int[S];
        int D = -1;
        for(int i =0; i<S; i++) {
            inputs = br.readLine().split(" ");
            int dir = Integer.parseInt(inputs[0]);
            int pos = Integer.parseInt(inputs[1]);

            if (dir == 1) {
                store[i] = pos;
            } else if (dir == 2) {
                int temp = N + M;
                temp += N - pos;
                store[i] = temp;
            } else if (dir == 3) {
                int temp = N * 2 + M;
                temp += M - pos;
                store[i] = temp;
            } else if (dir == 4) {
                int temp = N;
                temp += + pos;
                store[i] = temp;
            }
        }

        inputs = br.readLine().split(" ");
        int dir = Integer.parseInt(inputs[0]);
        int pos = Integer.parseInt(inputs[1]);
        if (dir == 1) {
            D = pos;
        } else if (dir == 2) {
            int temp = N + M;
            temp += N - pos;
            D = temp;
        } else if (dir == 3) {
            int temp = N * 2 + M;
            temp += M - pos;
            D = temp;
        } else if (dir == 4) {
            int temp = N;
            temp += pos;
            D = temp;
        }

        int answer = 0;
        for(int i = 0; i<S; i++) {
            int case1 =  Math.abs(store[i]-D);
            int case2 = load - case1;
            // System.out.println(store[i]);
            answer+= Math.min(case1, case2);
        }
        // System.out.println(D);
        System.out.println(answer);
    }
}
