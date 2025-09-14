import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int K;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        arr = new int[N];
        visited = new boolean[N];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        dfs(500, 0);
        System.out.println(count);
    }

    private static void dfs(
        final int weight,
        final int index
    ) {
        if (index == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && weight + arr[i] - K >= 500) {
                visited[i] = true;
                dfs(weight + arr[i] - K, index + 1);
                visited[i] = false;
            }
        }
    }
}
