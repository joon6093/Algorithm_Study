import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            list.get(B).add(A);
        }
        int start = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        visited[start] = true;
        dfs(start);

        System.out.println(result);
    }

    private static void dfs(int start) {
        for (int i = 0; i < list.get(start).size(); i++) {
            if (!visited[list.get(start).get(i)]) {
                visited[list.get(start).get(i)] = true;
                result += 1;
                dfs(list.get(start).get(i));
            }
        }
    }
}
