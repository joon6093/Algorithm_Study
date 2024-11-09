import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            List<String> words = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                words.add(st.nextToken());
            }
            Collections.reverse(words);
            bw.write(String.format("Case #%d: " + String.join(" ", words) + "%n", i));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
