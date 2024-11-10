import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            switch (arr[0]) {
                case "push":
                    queue.add(Integer.parseInt(arr[1]));
                    break;
                case "pop":
                    bw.write((queue.isEmpty() ? -1 : queue.poll()) + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write((queue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((queue.isEmpty() ? -1 : queue.peek()) + "\n");
                    break;
                case "back":
                    bw.write((queue.isEmpty() ? -1 : ((LinkedList<Integer>) queue).getLast()) + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
