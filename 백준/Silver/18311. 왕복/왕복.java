import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long K = Long.parseLong(input[1]);

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        for (int i = 0; i < N; i++) {
            K -= arr[i];
            if (K < 0) {
                System.out.println(i + 1);
                return;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            K -= arr[i];
            if (K < 0) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
