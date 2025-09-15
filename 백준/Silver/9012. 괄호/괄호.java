import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split("");
            Deque<String> stack = new ArrayDeque<>();
            for (String s : input) {
                if ("(".equals(s)) {
                    stack.push(s);
                } else {
                    if (stack.isEmpty() || !"(".equals(stack.pop())) {
                        stack.push(s);
                        break;
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
