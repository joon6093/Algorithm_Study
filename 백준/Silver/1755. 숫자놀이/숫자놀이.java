import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] number = {"Zero", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine"};

        Map<String, Integer> map = new TreeMap<>();
        for (int i = M; i <= N; i++) {
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                sb.append(number[s.charAt(j) - '0']);
            }
            map.put(sb.toString(), i);
        }

        int count = 0;
        for (Integer value : map.values()) {
            System.out.print(value);
            count++;
            if (count % 10 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}
