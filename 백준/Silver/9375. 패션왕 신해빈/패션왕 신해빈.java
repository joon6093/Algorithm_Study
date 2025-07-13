import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                String value = input[1];
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            int answer = 1;
            for (int count : map.values()) {
                answer *= (count + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
