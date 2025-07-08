import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String command = line.split(" ")[0];
            if (command.equals("push")) {
                int num = Integer.parseInt(line.split(" ")[1]);
                stack.push(num);
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                    bw.flush();
                } else {
                    bw.write(stack.pop() + "\n");
                    bw.flush();
                }
            } else if (command.equals("size")) {
                bw.write(stack.size() + "\n");
                bw.flush();
            } else if (command.equals("empty")) {
                bw.write((stack.isEmpty() ? "1" : "0") + "\n");
                bw.flush();
            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                    bw.flush();
                } else {
                    bw.write(stack.peek() + "\n");
                    bw.flush();
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
