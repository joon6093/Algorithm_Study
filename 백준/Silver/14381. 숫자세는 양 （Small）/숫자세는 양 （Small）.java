import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int T = Integer.parseInt(br.readLine());
            int answer = 0;
            Set<Integer> set = new HashSet<>();
            if (T != 0) {
                int index = 1;
                while (set.size() != 10) {
                    int temp = T * index;
                    String tempStr = String.valueOf(temp);
                    for (int k = 0; k < tempStr.length(); k++) {
                        char tempChar = tempStr.charAt(k);
                        if (tempChar >= '0' && tempChar <= '9') {
                            set.add(tempChar - '0');
                        }
                    }
                    index++;
                }
                answer = T * (index - 1);
            }
            System.out.print("Case #" + (i + 1) + ": ");
            if (answer == 0) {
                System.out.println("INSOMNIA");
            } else {
                System.out.println(answer);
            }
        }
    }
}
