import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] board = new char[N][M];
            int Ix = 0, Iy = 0;

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    char c = line.charAt(j);
                    board[i][j] = c;
                    if (c == 'I') {
                        Ix = i;
                        Iy = j;
                    }
                }
            }

            int count = 0;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            boolean[][] visited = new boolean[N][M];

            visited[Ix][Iy] = true;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{Ix, Iy});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (!visited[nx][ny] && board[nx][ny] != 'X') {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                            if (board[nx][ny] == 'P') {
                                count++;
                            }
                        }
                    }
                }
            }

            bw.write(count == 0 ? "TT\n" : count + "\n");
            bw.flush();
        }
    }
}
