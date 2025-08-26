import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            int gcd = gcd(arr[0], arr[i]);
            sb.append(arr[0] / gcd).append("/").append(arr[i] / gcd).append("\n");
        }

        System.out.print(sb);
    }

    private static int gcd(
        int a,
        int b
    ) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
