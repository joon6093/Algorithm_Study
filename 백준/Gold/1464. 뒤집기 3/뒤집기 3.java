import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String answer = String.valueOf(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (answer.charAt(i - 1) < input.charAt(i)) {
                answer = input.charAt(i) + answer;
            } else {
                answer = answer + input.charAt(i);
            }
        }

        StringBuffer sb = new StringBuffer(answer);
        String reverse = sb.reverse().toString();
        bw.write(reverse);
        bw.flush();
        bw.close();
    }
}
