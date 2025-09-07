import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int leftWeight = arr[0];
        int rightWeight = arr[1];
        for (int i = 2; i < N; i++) {
            if (leftWeight == rightWeight) {
                leftWeight += arr[i];
            } else {
                if (leftWeight < rightWeight) {
                    leftWeight += arr[i];
                } else {
                    rightWeight += arr[i];
                }
            }
        }

        int needWeight = Math.abs(leftWeight - rightWeight);
        int result = 0;
        int[] arr2 = {100, 50, 20, 10, 5, 2, 1};
        for (int weight : arr2) {
            result += needWeight / weight;
            needWeight %= weight;
        }
        System.out.println(result);
    }
}
