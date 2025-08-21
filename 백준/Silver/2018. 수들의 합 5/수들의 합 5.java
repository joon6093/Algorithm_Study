import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;
        while (left <= N) {
            while (++right <= N) {
                sum += right;
                if (sum == N) {
                    answer++;
                } else if (sum > N) {
                    break;
                }
            }
            while (++left <= N) {
                sum -= left;
                if (sum == N) {
                    answer++;
                } else if (sum < N) {
                    break;
                }
            }
        }

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
