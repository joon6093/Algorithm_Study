import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int MAX = 100000;
        int[] visited = new int[MAX + 1];
        int[] prev = new int[MAX + 1];

        Arrays.fill(prev, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                break;
            }

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next >= 0 && next <= MAX && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    prev[next] = cur;
                    q.add(next);
                }
            }
        }

        int time = visited[K] - 1;
        System.out.println(time);

        List<Integer> path = new ArrayList<>();
        for (int i = K; i != -1; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);

        for (int p : path) {
            System.out.print(p + " ");
        }
    }
}
