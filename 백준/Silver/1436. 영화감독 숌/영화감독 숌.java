import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int num = 666;
        while (true) {
            if (Integer.toString(num).contains("666")) {
                N--;
                if (N == 0) {
                    bufferedWriter.write(Integer.toString(num));
                    bufferedWriter.flush();
                    break;
                }
            }
            num++;
        }
    }
}
