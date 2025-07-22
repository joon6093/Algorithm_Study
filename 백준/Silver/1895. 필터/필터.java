import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[][] map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            String[] lineArray = line.split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(lineArray[j]);
            }
        }

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {
                List<Integer> temp = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        temp.add(map[i + k][j + l]);
                    }
                }
                temp.sort(Integer::compareTo);
                answerList.add(temp.get(4));
            }
        }

        int T = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int num : answerList) {
            if (num >= T) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
