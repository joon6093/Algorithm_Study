import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int N;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(inputs[0]);
            arr[i][1] = Integer.parseInt(inputs[1]);
        }

        dfs(0, 1, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(
        int depth,
        int sour,
        int bitter,
        int count
    ) {
        if (depth == N) {
            if (count != 0) {
                answer = Math.min(answer, Math.abs(sour - bitter));
            }
            return;
        }

        dfs(depth + 1, sour * arr[depth][0], bitter + arr[depth][1], count + 1);
        dfs(depth + 1, sour, bitter, count);
    }
}
