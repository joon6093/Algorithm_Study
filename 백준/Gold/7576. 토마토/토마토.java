import java.io.*;
import java.util.*;

class Main {
    
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] arr;
    static int day = 0;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        M = Integer.parseInt(inputs[0]);
        N = Integer.parseInt(inputs[1]);
        
        arr = new int[N][M];
        List<int[]> list =  new ArrayList<>();
        for (int i=0; i<N; i++) {
                inputs = br.readLine().split(" ");
                for (int j=0; j<M; j++) {
                      arr[i][j] = Integer.parseInt(inputs[j]);
                      if (arr[i][j] == 1) {
                        list.add(new int[]{i, j});
                      }
                }
        }       

        bfs(list);
        for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                      if (arr[i][j] == 0) {
                        System.out.println(-1);
                        return;
                      }
                        // System.out.print(arr[i][j]);
                }
                //  System.out.println();
        }  
        System.out.println(day);
    }

    static void bfs(List<int[]> list) {
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i=0; i<list.size(); i++) {
                deque.add(new int[]{list.get(i)[0], list.get(i)[1], 0});
        }
       
        while(!deque.isEmpty()) {
                int[] temp = deque.pollFirst();
                int h = temp[0];
                int w = temp[1];
                day = temp[2];

                for (int i=0; i<4; i++) {
                        int dh = h + dy[i];
                        int dw = w + dx[i];
                        if (dh <0 || dh > N-1 || dw<0 || dw >M-1) {
                                continue;
                        }
                        if(arr[dh][dw] == 1 || arr[dh][dw] == -1 ) {
                                continue;
                        }
                        arr[dh][dw] = 1;
                        deque.add(new int[]{dh, dw, day+1});
                }
        }
    }
}
