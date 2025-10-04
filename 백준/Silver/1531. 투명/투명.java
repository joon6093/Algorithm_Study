import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] arr = new int[101][101];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int x1 = Integer.parseInt(inputs[0]);
            int y1 = Integer.parseInt(inputs[1]);
            int x2 = Integer.parseInt(inputs[2]);
            int y2 = Integer.parseInt(inputs[3]);

            for (int j = y1; j <= y2; j++) {
                for (int k = x1; k <= x2; k++) {
                    arr[j][k]++;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (arr[i][j] > M) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
