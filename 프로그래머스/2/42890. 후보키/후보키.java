import java.util.*;

class Solution {
    
    List<List<String>> list;
    List<Integer> key;
    List<List<Integer>> candidateKeys = new ArrayList<>();
    int answer = 0;
    
    public int solution(String[][] relation) {
        
        for (int i = 1; i<relation[0].length+1; i++) {
            list = new ArrayList<>();
            key = new ArrayList<>();
            for (int j = 0; j<relation.length; j++) {
                list.add(new ArrayList<>());
            }
        
            dfs(relation, 0, 0, i);
        }
        
        return answer;
    }
    
    private void dfs(String[][] relation, int depth, int index, int size) {
        if (depth == size) {
            Set<List<String>> set = new HashSet<>(list);
            if (list.size() == set.size()) { // 유일성 체크
                if (isMinimal()) {           // 최소성 체크 추가
                    answer++;
                    candidateKeys.add(new ArrayList<>(key));
                }
            }
            return;
        }
        
        for (int i = index; i<relation[0].length; i++) {
            for (int j = 0; j<relation.length; j++) {
                list.get(j).add(relation[j][i]);
            }
            key.add(i);
            
            dfs(relation, depth + 1, i + 1, size);
            
            for (int j = 0; j<relation.length; j++) {
                list.get(j).remove(list.get(j).size() - 1);
            }
            key.remove(key.size() - 1);
        }
    }
    
    private boolean isMinimal() {
        for (List<Integer> ck : candidateKeys) {
            if (key.containsAll(ck)) { 
                return false;
            }
        }
        return true;
    }
}
