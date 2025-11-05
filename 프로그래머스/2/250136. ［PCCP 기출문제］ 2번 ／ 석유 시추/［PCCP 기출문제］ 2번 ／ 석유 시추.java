import java.util.*;

class Solution {
    
    boolean[][] visited; 
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    int N, M;
    Map<Integer, Integer> map = new HashMap<>();
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        int index = 1;
        for(int i =0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (land[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                
                int count = bfs(land, i, j, index);
                map.put(index, count);
                index++;
            }
        }
        
        for(int j=0; j<M; j++) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for(int i=0; i<N; i++) {
                if (land[i][j] == 0) {
                    continue;
                }
                
                set.add(land[i][j]);
            }
            
            for(int key: set) {
                sum += map.get(key);
            }
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    private int bfs(int[][] land, int i, int j, int index) {
        if (visited[i][j]) {
            return 0;
        }  
        
        int sum = 1;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});
        visited[i][j] = true;
        land[i][j] = index;
        while(!deque.isEmpty()) {
            int[] temp = deque.pollFirst();
            int currentI = temp[0];
            int currentJ = temp[1];
            
            for(int k=0; k<4; k++) {
                int nextI = currentI + dx[k];
                int nextJ = currentJ + dy[k];
                
                if(nextI < 0 || nextI > N-1 || nextJ < 0 || nextJ > M-1) {
                    continue;
                }
                
                if(visited[nextI][nextJ]) {
                    continue;
                }
                
                if(land[nextI][nextJ] == 0) {
                    continue;
                }
                
                deque.add(new int[]{nextI, nextJ});
                visited[nextI][nextJ] = true;
                land[nextI][nextJ] = index;
                sum++;
            }
        }
    
        return sum;
    }
}