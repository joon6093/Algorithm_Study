import java.io.*;
import java.util.*;

class Main {

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int index, int price) {
        if (index == 3) {
            answer = Math.min(answer, price);
            return;
        }

        for(int i=1; i<N-1; i++) {
            for(int j=1; j<N-1; j++) {
                if(!isPossible(i, j)) {
                    continue;
                }
                int currnet = mark(i, j, true);
                dfs(index + 1, price + currnet);
                mark(i, j, false);
            }
        }
    }

    private static boolean isPossible(int i, int j) {
        if (visited[i][j]) {
            return false;
        }

        for (int k=0; k<4; k++) {
            int nextI = i+dx[k];
            int nextJ = j+dy[k];

            if(visited[nextI][nextJ]) {
                return false;
            }
        }

        return true;
    }

    private static int mark(int i, int j, boolean temp) {
        int pirce = 0;
        visited[i][j] = temp;
        pirce += arr[i][j];
        for (int k=0; k<4; k++) {
            int nextI = i+dx[k];
            int nextJ = j+dy[k];

            visited[nextI][nextJ] = temp;
            pirce += arr[nextI][nextJ];
        }

        return pirce;
    }
}
