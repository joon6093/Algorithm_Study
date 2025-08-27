import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input2[j]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int[][] visited = new int[N][M];
            for (int j = 0; j < M; j++) {
                visited[i][j] = 1;
                max = Math.max(max, dfs(arr, visited, i, j, arr[i][j], 1));
            }
        }

        System.out.println(max);
    }

    private static int dfs(
        int[][] arr,
        int[][] visited,
        int x,
        int y,
        int sum,
        int count
    ) {
        if (count == 4) {
            return sum;
        }
        int max = Integer.MIN_VALUE;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                if (visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    if (count == 2) {
                        max = Math.max(max, dfs(arr, visited, x, y, sum + arr[nx][ny], count + 1));
                    }
                    max = Math.max(max, dfs(arr, visited, nx, ny, sum + arr[nx][ny], count + 1));
                    visited[nx][ny] = 0;
                }
            }
        }

        return max;
    }
}
