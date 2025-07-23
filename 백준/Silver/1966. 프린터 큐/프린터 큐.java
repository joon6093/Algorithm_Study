import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Deque<Integer> documentDeque = new ArrayDeque<>();
            Deque<Integer> priorityDeque = new ArrayDeque<>();

            st = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < N; j++) {
                documentDeque.offer(j);
                priorityDeque.offer(Integer.valueOf(st.nextToken()));
            }

            int count = 1;

            while (!documentDeque.isEmpty()) {
                int max = Collections.max(priorityDeque);
                int documentIndex = documentDeque.pollFirst();
                int documentPriority = priorityDeque.pollFirst();

                if (documentPriority != max) {
                    documentDeque.offerLast(documentIndex);
                    priorityDeque.offerLast(documentPriority);
                } else {
                    if (documentIndex == M) {
                        System.out.println(count);
                        break;
                    }
                    count++;
                }
            }
        }
    }
}
