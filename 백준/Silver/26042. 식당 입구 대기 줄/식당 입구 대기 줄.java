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
        int maxSize = 0;
        int lastNumber = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            String command = arr[0];
            if ("1".equals(command)) {
                queue.add(Integer.parseInt(arr[1]));
                if (maxSize < queue.size()) {
                    maxSize = queue.size();
                    lastNumber = ((LinkedList<Integer>) queue).getLast();
                } else if (maxSize == queue.size()) {
                    lastNumber = Math.min(lastNumber, ((LinkedList<Integer>) queue).getLast());
                }
            } else if ("2".equals(command)) {
                queue.poll();
            }
        }

        bw.write(maxSize + " " + lastNumber + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
