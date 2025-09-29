import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var inputs = br.readLine().split(" ");
        var A = Integer.parseInt(inputs[0]);
        var K = Integer.parseInt(inputs[1]);

        var dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[A] = 0;

        for (var i = A; i < K; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (i + 1 <= K) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
            if (i * 2 <= K) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
        }

        System.out.println(dp[K]);
    }
}
