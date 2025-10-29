import java.io.*;
import java.util.*;

class Main {

    static int N, S;
    static int[] arr;
    static int answer;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        S = Integer.parseInt(inputs[1]);
        arr = new int[N];

        inputs = br.readLine().split(" ");
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        for(int i=1; i<N+1; i++) {
            dfs(0, 0, 0, i);
        }

        System.out.println(answer);
    }

    private static void dfs(int index, int current, int sum, int count) {
        if (current == count) {
            if(sum == S) {
                answer++;
            }

            return;
        }

        for(int i = index; i<N; i++) {
            dfs(i+1, current +1, sum+arr[i], count);
        }
    }
}
