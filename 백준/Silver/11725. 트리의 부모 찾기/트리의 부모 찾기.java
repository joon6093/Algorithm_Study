import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String[] inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];
        dfs(1);
        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
                parent[child] = node;
            }
        }
    }
}
