import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = bufferedReader.readLine();
        List<String> nCharList = Arrays.asList(N.split(""));
        nCharList.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String c : nCharList) {
            sb.append(c);
        }

        bufferedWriter.write(String.valueOf(sb));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
