import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] input = br.readLine().split("");
            List<String> list = List.of(input);
            Deque<String> stack = new ArrayDeque<>();
            Deque<String> temp = new ArrayDeque<>();
            for (String s : list) {
                if ("<".equals(s)) {
                    if (!stack.isEmpty()) {
                        temp.push(stack.pop());
                    }
                } else if (">".equals(s)) {
                    if (!temp.isEmpty()) {
                        stack.push(temp.pop());
                    }
                } else if ("-".equals(s)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(s);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            while (!temp.isEmpty()) {
                sb.append(temp.pop());
            }
            System.out.println(sb);
        }
    }
}
