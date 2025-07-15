import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);

        final int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            final String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        final int[][][] dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    dp[i][j][d] = Integer.MAX_VALUE;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = arr[0][j];
            }
        }

        final int[] dx = {1, 1, 1};
        final int[] dy = {-1, 0, 1};

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                for (int prevDir = 0; prevDir < 3; prevDir++) {
                    if (dp[i][j][prevDir] == Integer.MAX_VALUE) {
                        continue;
                    }

                    for (int nextDir = 0; nextDir < 3; nextDir++) {
                        if (prevDir == nextDir) {
                            continue;
                        }

                        final int ni = i + dx[nextDir];
                        final int nj = j + dy[nextDir];

                        if (ni < N && nj >= 0 && nj < M) {
                            dp[ni][nj][nextDir] = Math.min(dp[ni][nj][nextDir],
                                dp[i][j][prevDir] + arr[ni][nj]);
                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[N - 1][j][d]);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
