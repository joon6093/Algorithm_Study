import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[][] arr;
    static int[][] visted;
    static List<Integer> answer = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        arr = new int[n][m];
        visted = new int[n][m];
        for(int i = 0; i<n; i++) {
            inputs = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for(int i = 0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i][j] == 1 && visted[i][j]==0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer.size());

        int max = 0;
        for (int i =0; i<answer.size(); i++) {
            max = Math.max(answer.get(i), max);
        }
        System.out.println(max);
    }

    private static void bfs(int i, int j) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});
        visted[i][j] = 1;
        int count =1;
        while(!deque.isEmpty()) {
            int[] temp = deque.pollFirst();
            int y = temp[0];
            int x = temp[1];
            for (int k=0; k<4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if(ny<0 || nx<0 || ny>n-1 || nx>m-1) {
                    continue;
                } 
                if(visted[ny][nx] == 1) {
                    continue;
                }
                if(arr[ny][nx] == 1) {
                    count++;
                    visted[ny][nx] = 1;
                    deque.add(new int[] {ny,nx});
                }
            }
        }
        answer.add(count);
    }
}
