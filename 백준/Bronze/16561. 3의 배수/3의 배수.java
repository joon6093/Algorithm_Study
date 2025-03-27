import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) / 3;
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (n - i - j > 0) {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}
