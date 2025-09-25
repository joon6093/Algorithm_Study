import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                String temp = line[j];
                if (Objects.equals(temp, ".")) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }

        List<int[]> answer = new ArrayList<>();
        int[][] mark = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }

                int size = 0;
                while (true) {
                    int nx1 = i - (size + 1);
                    int nx2 = i + (size + 1);
                    int ny1 = j - (size + 1);
                    int ny2 = j + (size + 1);
                    if (nx1 < 0 || nx2 >= N || ny1 < 0 || ny2 >= M) {
                        break;
                    }
                    if (arr[nx1][j] != 1 || arr[nx2][j] != 1 || arr[i][ny1] != 1 || arr[i][ny2] != 1) {
                        break;
                    }
                    size++;
                }

                for (int k = 1; k <= size; k++) {
                    answer.add(new int[]{i + 1, j + 1, k});
                    mark[i][j] = 1;
                    mark[i - k][j] = 1;
                    mark[i + k][j] = 1;
                    mark[i][j - k] = 1;
                    mark[i][j + k] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != mark[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer.size());
        for (int[] temp : answer) {
            System.out.println(temp[0] + " " + temp[1] + " " + temp[2]);
        }
    }
}
