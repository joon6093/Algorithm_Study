import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < D; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            for (int j = 0; j < N; j++) {
                if (arr[j][0] == i) {
                    if (arr[j][1] <= D) {
                        dp[arr[j][1]] = Math.min(dp[arr[j][1]], dp[i] + arr[j][2]);
                    }
                }
            }
        }

        System.out.println(dp[D]);
    }
}
