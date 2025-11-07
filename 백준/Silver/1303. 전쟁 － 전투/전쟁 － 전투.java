import java.io.*;
import java.util.*;

public class Main {
    static int N, M;              // N: 가로(열), M: 세로(행)
    static char[][] grid;         // [M][N]
    static boolean[][] visited;   // [M][N]
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        grid = new char[M][N];
        visited = new boolean[M][N];

        for (int r = 0; r < M; r++) {
            String line = br.readLine().trim();
            for (int c = 0; c < N; c++) {
                grid[r][c] = line.charAt(c);
            }
        }

        int white = 0;
        int blue = 0;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    int size = bfs(r, c, grid[r][c]);
                    if (grid[r][c] == 'W') white += size * size;
                    else blue += size * size;
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    static int bfs(int sr, int sc, char color) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[sr][sc] = true;
        q.offer(new int[]{sr, sc});
        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dy[k];
                int nc = c + dx[k];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] != color) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
                count++;
            }
        }
        return count;
    }
}
