import java.util.*;

class Solution {
    
    List<List<Integer>> list;
    boolean[] visited;
    int n;
    
    public int solution(int n, int[][] computers) {
        n = n;
        int answer = 0;
        list = new ArrayList<>();
        visited = new boolean[n];
        for(int i =0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i=0; i<computers.length; i++) {
            for (int j =0; j<n; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1){
                    list.get(i).add(j);
                }
            }
        }
        
        for(int i =0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int index) {
        for(int i = 0; i<list.get(index).size(); i++) {
            if (visited[list.get(index).get(i)]) {
                continue;
            }
            visited[list.get(index).get(i)] = true;
            dfs(list.get(index).get(i));
        }
    }
}