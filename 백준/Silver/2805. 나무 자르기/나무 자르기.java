import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] inputs = br.readLine().split(" ");
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
            max = Math.max(max, arr[i]);
        }

        int left = 1;
        int right = max;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }
            if (sum >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
