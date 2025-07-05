import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[i] = score;
        }

        int answer = 0;
        for (int i = N - 2; i >= 0; i--) {
            int currentScore = scores[i];
            int prevScore = scores[i + 1];
            if (currentScore >= prevScore) {
                int requiredScore = prevScore - 1;
                answer += currentScore - requiredScore;
                scores[i] = requiredScore;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
