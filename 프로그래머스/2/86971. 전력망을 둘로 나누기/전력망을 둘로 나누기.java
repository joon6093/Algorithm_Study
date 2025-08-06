import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[][] arr;

    public int solution(
        int n,
        int[][] wires
    ) {
        int answer = n;
        arr = new int[n + 1][n + 1];

        for (int[] ints : wires) {
            arr[ints[0]][ints[1]] = 1;
            arr[ints[1]][ints[0]] = 1;
        }

        int a, b;
        for (int[] wire : wires) {
            a = wire[0];
            b = wire[1];

            arr[a][b] = 0;
            arr[b][a] = 0;

            answer = Math.min(answer, bfs(n, a));

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        return answer;
    }

    public int bfs(
        int n,
        int start
    ) {
        int[] visit = new int[n + 1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int point = queue.poll();
            visit[point] = 1;

            for (int i = 1; i <= n; i++) {
                if (visit[i] == 1) {
                    continue;
                }
                if (arr[point][i] == 1) {
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return Math.abs(n - 2 * cnt);
    }
}
