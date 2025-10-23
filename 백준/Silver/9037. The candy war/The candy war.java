import java.io.*;
import java.util.*;

public class Main {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            final int N = Integer.parseInt(br.readLine());
            final int[] candies = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int i = 0; i < N; i++) {
                if (candies[i] % 2 != 0) candies[i]++;
            }

            int count = 0;
            while (!isAllEqual(candies)) {
                final int[] give = new int[N];
                for (int i = 0; i < N; i++) {
                    give[i] = candies[i] / 2;
                    candies[i] /= 2;
                }

                for (int i = 0; i < N; i++) {
                    candies[(i + 1) % N] += give[i];
                }

                for (int i = 0; i < N; i++) {
                    if (candies[i] % 2 != 0) candies[i]++;
                }

                count++;
            }

            System.out.println(count);
        }
    }

    private static boolean isAllEqual(final int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[0]) return false;
        }
        return true;
    }
}
