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
        String input = br.readLine();
        String A = input.split(" ")[0];
        String B = input.split(" ")[1];
        List<Integer> cases = new ArrayList<>();

        for (int i = 0; i < B.length() - A.length() + 1; i++) {
            int caseCount = 0;
            for (int j = i; j < A.length() + i; j++) {
                if (A.charAt(j - i) != B.charAt(j)) {
                    caseCount++;
                }
            }
            cases.add(caseCount);
        }
        int answer = Collections.min(cases);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
