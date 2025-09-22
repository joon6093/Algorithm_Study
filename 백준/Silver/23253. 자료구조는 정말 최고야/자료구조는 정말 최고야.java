import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int answer = 0;
        while (M-- > 0) {
            int count = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[count];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < count; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Integer[] temp = arr.clone();
            Arrays.sort(temp, Collections.reverseOrder());

            if (!Arrays.equals(arr, temp)) {
                answer = 1;
                break;
            }
        }
        if (answer == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
