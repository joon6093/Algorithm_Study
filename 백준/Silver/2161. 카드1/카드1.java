import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            cards.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (!cards.isEmpty()) {
            if (index % 2 == 1) {
                sb.append(cards.get(0)).append(" ");
                cards.remove(0);
            } else {
                cards.add(cards.get(0));
                cards.remove(0);
            }
            index++;
        }

        System.out.println(sb);
    }
}
