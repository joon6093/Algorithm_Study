import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr1 = new int[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        for (int i = 0; i < 5; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr1[i][j] = Integer.parseInt(input[j]);
            }
        }
        int count = 0;

        for (int i = 0; i < 5; i++) {
            input = br.readLine().split(" ");
            for (int z = 0; z < 5; z++) {
                int num = Integer.parseInt(input[z]);
                count++;
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (arr1[j][k] == num) {
                            arr1[j][k] = 0;
                        }
                    }
                }

                if (count >= 12 && checkBingo() >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    private static int checkBingo() {
        int bingoCount = 0;

        for (int i = 0; i < 5; i++) {
            boolean rowBingo = true;
            boolean colBingo = true;
            for (int j = 0; j < 5; j++) {
                if (arr1[i][j] != 0) {
                    rowBingo = false;
                }
                if (arr1[j][i] != 0) {
                    colBingo = false;
                }
            }
            if (rowBingo) {
                bingoCount++;
            }
            if (colBingo) {
                bingoCount++;
            }
        }

        boolean diag1Bingo = true;
        boolean diag2Bingo = true;
        for (int i = 0; i < 5; i++) {
            if (arr1[i][i] != 0) {
                diag1Bingo = false;
            }
            if (arr1[i][4 - i] != 0) {
                diag2Bingo = false;
            }
        }
        if (diag1Bingo) {
            bingoCount++;
        }
        if (diag2Bingo) {
            bingoCount++;
        }

        return bingoCount;
    }
}
