import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] times = {4, 6, 4, 10};

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 7; j++) {
                    String name = st.nextToken();
                    if ("-".equals(name)) {
                        continue;
                    }
                    map.put(name, map.getOrDefault(name, 0) + times[i]);
                }
            }
        }

        String answer;
        if (map.isEmpty()) {
            answer = "Yes";
        } else {
            List<Integer> values = new ArrayList<>(map.values());
            Integer max = Collections.max(values);
            Integer min = Collections.min(values);
            if (max - min > 12) {
                answer = "No";
            } else {
                answer = "Yes";
            }
        }
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
