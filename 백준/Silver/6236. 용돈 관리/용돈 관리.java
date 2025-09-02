import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int arr[] = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int MAX = 100000 * 10000;
        int left = max;
        int right = MAX;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            int current = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > current) {
                    count++;
                    current = mid;
                    current -= arr[i];
                } else {
                    current -= arr[i];
                }
            }
            if (count <= M) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
