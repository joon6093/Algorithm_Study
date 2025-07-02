import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        for (int i = 0; i < S.length() / 2; i++) {
            if (S.charAt(i) != S.charAt(S.length() - 1 - i)) {
                bw.write("0");
                bw.flush();
                bw.close();
                return;
            }
        }

        bw.write("1");
        bw.flush();
        bw.close();
    }
}
