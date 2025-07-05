import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Integer weight = Integer.valueOf(br.readLine());
            weights.add(weight);
        }

        weights.sort(Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (weights.get(i) * (i + 1) > answer) {
                answer = weights.get(i) * (i + 1);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
