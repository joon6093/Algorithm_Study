import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        int answer = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(board, i, j, i, j + 1);
                answer = Math.max(answer, check(board));
                swap(board, i, j, i, j + 1);
            }
        }

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                swap(board, i, j, i + 1, j);
                answer = Math.max(answer, check(board));
                swap(board, i, j, i + 1, j);
            }
        }
        
        System.out.println(answer);
        br.close();
    }

    private static void swap(
        char[][] board,
        int x1,
        int y1,
        int x2,
        int y2
    ) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    private static int check(char[][] board) {
        int N = board.length;
        int max = 1;

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
