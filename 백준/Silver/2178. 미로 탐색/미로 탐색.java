import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M + 1];
        queue.add(new int[]{1, 1});
        visited[1][1] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int distance = 0;
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            distance++;
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                if (x == N && y == M) {
                    found = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                        if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        System.out.println(distance);
    }
}
