import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        Deque<Integer> temp = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            temp.addLast(Integer.parseInt(inputs[i]));
        }

        int goal = 1;
        while (goal <= N) {
            if (!temp.isEmpty() && temp.peekFirst() == goal) {
                temp.pollFirst();
                goal++;
            } else if (!stack.isEmpty() && stack.peekFirst() == goal) {
                stack.pollFirst();
                goal++;
            } else if (!temp.isEmpty()) {
                stack.addFirst(temp.pollFirst());
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}
