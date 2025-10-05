import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");
        int[] arr = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        for (int i = arr.length / 2; i >= 1; i--) {
            for (int j = 0; j <= arr.length - (2 * i); j++) {
                int leftSum = 0;
                int rightSum = 0;
                for (int k = 0; k < i; k++) {
                    leftSum += arr[j + k];
                    rightSum += arr[j + k + i];
                }
                if (leftSum == rightSum) {
                    System.out.println(2 * i);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
