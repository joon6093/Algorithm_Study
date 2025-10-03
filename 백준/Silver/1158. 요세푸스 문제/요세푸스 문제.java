import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine().split(" ");
        var N = Integer.parseInt(input[0]);
        var K = Integer.parseInt(input[1]);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            result.add(deque.pollFirst());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i != result.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
