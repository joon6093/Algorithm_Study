import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        int min = Math.min(N, M);
        int answer = 1;
        for (int i = 1; i < min; i++) {
            for (int row = 0; row < N - i; row++) {
                for (int col = 0; col < M - i; col++) {
                    int x1 = arr[row][col];
                    int x2 = arr[row][col + i];
                    int x3 = arr[row + i][col];
                    int x4 = arr[row + i][col + i];

                    if (x1 == x2 && x1 == x3 && x1 == x4) {
                        answer = i + 1;
                        break;
                    }
                }
                if (answer == i + 1) {
                    break;
                }
            }
        }
        System.out.println(answer * answer);
    }
}
