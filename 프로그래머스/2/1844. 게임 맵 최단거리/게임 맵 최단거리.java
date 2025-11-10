import java.util.*;

class Solution {
    int [][] maps;
    boolean [][] visited;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] temp) {
        maps = temp;
        int n = maps.length;
        int m = maps[0].length;

        // if (maps[0][0] == 0 || maps[n-1][m-1] == 0) return -1;

        visited = new boolean[n][m];
        return bfs(n, m);
    }

    private int bfs(int n, int m) {
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0, 1}); 
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == n - 1 && y == m - 1) return dist;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.addLast(new int[]{nx, ny, dist + 1});
            }
        }
        return -1;
    }
}
