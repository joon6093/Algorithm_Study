import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr = new int[19][19];
    static int[] dx = {1, 0, 1, -1};
    static int[] dy = {0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] == 0) continue;
                if (check(i, j)) {
                    System.out.println(arr[i][j]);
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static boolean check(int i, int j) {
        int color = arr[i][j];

        for (int k = 0; k < 4; k++) {
            int count = 1;
            int nextI = i;
            int nextJ = j;

            while (true) {
                nextI += dx[k];
                nextJ += dy[k];
                if (!inRange(nextI, nextJ) || arr[nextI][nextJ] != color) break;
                count++;
            }

            if (count == 5) {
                int prevI = i - dx[k];
                int prevJ = j - dy[k];
                int nextI2 = i + dx[k] * 5;
                int nextJ2 = j + dy[k] * 5;

                if (inRange(prevI, prevJ) && arr[prevI][prevJ] == color) continue;
                if (inRange(nextI2, nextJ2) && arr[nextI2][nextJ2] == color) continue;

                return true;
            }
        }
        return false;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}
