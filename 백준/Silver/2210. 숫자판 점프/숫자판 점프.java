import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr = new int[5][5];
    static Set<String> set = new HashSet<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(1, String.valueOf(arr[i][j]), i, j);
            }
        }

        System.out.println(set.size());
    }

    private static void dfs(int depth, String current, int x, int y) {
        if (depth == 6) {             
            set.add(current);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;

            dfs(depth + 1, current + arr[nx][ny], nx, ny);
        }
    }
}
