import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Deque<int[]> deque = new LinkedList<>();
        int index = 1;
        deque.push(new int[]{Integer.parseInt(input[0]), index++});
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(" ");

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            boolean found = false;
            while (!deque.isEmpty()) {
                int[] top = deque.peek();
                if (top[0] < num) {
                    deque.pop();
                } else if (top[0] == num) {
                    sb.append(top[1]).append(" ");
                    deque.pop();
                    found = true;
                    break;
                } else {
                    sb.append(top[1]).append(" ");
                    found = true;
                    break;
                }
            }
            if (!found) {
                sb.append(0).append(" ");
            }
            deque.push(new int[]{num, index++});
        }
        System.out.println(sb);
    }
}
