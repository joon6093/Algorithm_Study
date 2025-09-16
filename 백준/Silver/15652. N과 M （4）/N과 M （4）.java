import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new int[N];
        dfs(0, 0);
    }

    static void dfs(
        int start,
        int depth
    ) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(visited[i] + 1).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = start; i < N; i++) {
            visited[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
