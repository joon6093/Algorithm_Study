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
        int ZeroCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                ZeroCount++;
            }
        }
        int OneCount = S.length() - ZeroCount;
        ZeroCount = ZeroCount / 2;
        OneCount = OneCount / 2;

        int inputZeroCount = 0;
        int inputOneCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                inputOneCount += 1;
                if (inputOneCount > OneCount) {
                    sb.append('1');
                }
            } else {
                inputZeroCount += 1;
                if (inputZeroCount <= ZeroCount) {
                    sb.append('0');
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
