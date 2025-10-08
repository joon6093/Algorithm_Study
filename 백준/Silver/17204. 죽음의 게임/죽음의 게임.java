import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        graph = new int[N];
        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        int answer = 0;
        visited = new boolean[N];
        while (!visited[index]) {
            visited[index] = true;
            index = graph[index];
            answer++;
            if (index == K) {
                System.out.println(answer);
                return;
            }
        }
        System.out.println(-1);
    }
}
