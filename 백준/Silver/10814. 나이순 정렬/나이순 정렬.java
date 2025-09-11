import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split(" ");
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> Integer.parseInt(a[0])));

        for (String[] s : arr) {
            System.out.println(s[0] + " " + s[1]);
        }
    }
}
