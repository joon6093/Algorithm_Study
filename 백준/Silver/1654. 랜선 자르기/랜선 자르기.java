import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lengths = new int[K];
        int maxLength = 0;
        for (int i = 0; i < K; i++) {
            lengths[i] = Integer.parseInt(br.readLine());
            if (lengths[i] > maxLength) {
                maxLength = lengths[i];
            }
        }

        long left = 1;
        long right = maxLength;
        long result = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int length : lengths) {
                count += length / mid;
            }
            if (count >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(result);
    }
}
