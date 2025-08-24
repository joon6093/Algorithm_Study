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

        String[][] board = new String[N][M];
        int Ix = 0;
        int Iy = 0;
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = line[j];
                if (line[j].equals("I")) {
                    Ix = i;
                    Iy = j;
                }
            }
        }
        int count = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] visited = new int[N][M];
        visited[Ix][Iy] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{Ix, Iy});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (visited[nx][ny] == 0 && !board[nx][ny].equals("X")) {
                        visited[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                        if (board[nx][ny].equals("P")) {
                            count++;
                        }
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }
}
