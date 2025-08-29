import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][M];
        int result = bfs(x1, y1, x2, y2);
        System.out.println(result);
    }

    static int bfs(
        int sx,
        int sy,
        int ex,
        int ey
    ) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        int jumps = 0;

        while (!q.isEmpty()) {
            Queue<int[]> nextQ = new LinkedList<>();
            jumps++;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    while (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                        if (map[nx][ny] == '0' || map[nx][ny] == '*') {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        } else if (map[nx][ny] == '1') {
                            visited[nx][ny] = true;
                            nextQ.add(new int[]{nx, ny});
                            break;
                        } else if (nx == ex && ny == ey) {
                            return jumps;
                        }
                        nx += dx[dir];
                        ny += dy[dir];
                    }
                }
            }
            q = nextQ;
        }
        return -1;
    }
}
