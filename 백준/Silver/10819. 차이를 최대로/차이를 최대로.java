import java.io.*;
import java.util.*;

class Main {

    static int[] arr;
    static int[] current;
    static int N;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        current = new int[N];
        visited = new boolean[N];
        
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int count) {
        if (count == N) {
            int temp = 0;
            for (int i =0; i<N-1; i++) {
                temp += Math.abs(current[i]-current[i+1]);
            }

            answer = Math.max(answer, temp);
            return;
        }
        for(int i=0; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            current[count] = arr[i];
            visited[i] = true;
            dfs(count+1);
            visited[i] = false;
        }
    }
}
