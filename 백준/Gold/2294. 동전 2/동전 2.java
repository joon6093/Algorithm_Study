import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        for (int i = 1; i < k + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < k + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] <= i && dp[i - arr[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        int answer = -1;
        if (dp[k] != Integer.MAX_VALUE) {
            answer = dp[k];
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
