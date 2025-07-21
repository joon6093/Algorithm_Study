import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        String d = input[1];

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < String.valueOf(i).length(); j++) {
                if (String.valueOf(i).charAt(j) == d.charAt(0)) {
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
