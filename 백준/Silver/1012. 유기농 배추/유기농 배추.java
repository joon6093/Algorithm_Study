import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            map = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            for (int i = 0; i < K; i++) {
                String[] pos = br.readLine().split(" ");
                int x = Integer.parseInt(pos[0]);
                int y = Integer.parseInt(pos[1]);
                map[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(
        int i,
        int j
    ) {
        visited[i][j] = true;
        for (int dir = 0; dir < 4; dir++) {
            int ni = i + dy[dir];
            int nj = j + dx[dir];
            if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                if (map[ni][nj] == 1 && !visited[ni][nj]) {
                    dfs(ni, nj);
                }
            }
        }
    }
}
