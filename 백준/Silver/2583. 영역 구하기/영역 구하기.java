import java.io.*;
import java.util.*;

class Main {

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        M = Integer.parseInt(inputs[0]); // 세로 (y)
        N = Integer.parseInt(inputs[1]); // 가로 (x)
        int K = Integer.parseInt(inputs[2]);

        arr = new int[M][N];
        for (int i = 0; i < K; i++) {
            inputs = br.readLine().split(" ");
            int x1 = Integer.parseInt(inputs[0]);
            int y1 = Integer.parseInt(inputs[1]);
            int x2 = Integer.parseInt(inputs[2]);
            int y2 = Integer.parseInt(inputs[3]);

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    arr[y][x] = 1;
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (arr[y][x] == 0) {
                    answer.add(bfs(y, x));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    static int bfs(int sy, int sx) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{sy, sx});
        arr[sy][sx] = 1;
        int count = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int y = cur[0];
            int x = cur[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                if (arr[ny][nx] == 1) continue;
                arr[ny][nx] = 1;
                deque.add(new int[]{ny, nx});
            }
        }
        return count;
    }
}
