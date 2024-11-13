import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String skills = br.readLine();
        int answer = 0;
        int lCount = 0;
        int sCount = 0;

        for (int i = 0; i < n; i++) {
            char skill = skills.charAt(i);
            if (skill == 'L') {
                lCount++;
            } else if (skill == 'S') {
                sCount++;
            } else if (skill == 'R') {
                if (lCount == 0) {
                    break;
                } else {
                    lCount--;
                    answer++;
                }
            } else if (skill == 'K') {
                if (sCount == 0) {
                    break;
                } else {
                    sCount--;
                    answer++;
                }
            } else {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
