import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int N = words.length + 1;
        
        String[] wordsTemp = new String[N];
        wordsTemp[0] = begin;
        for(int i = 1; i<N; i++) {
            wordsTemp[i] = words[i-1];
        }
        
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        
        deque.add(new int[]{0, 0});
        visited[0] = true;
        while(!deque.isEmpty()) {
            int[] temp = deque.pollFirst();
            int index = temp[0];
            String currentWord = wordsTemp[index];
            int count = temp[1];
            
            if (currentWord.equals(target)) {
                return count;
            }
            
            for (int i =0; i<N; i++) {
                if (visited[i]) {
                    continue;
                }
                
                String change = wordsTemp[i];
                int diff = 0;
                for(int j = 0; j<currentWord.length(); j++) {
                    if (currentWord.charAt(j) != (change.charAt(j))){
                        diff++;
                    }
                    if (diff > 1) {
                        break;
                    }
                }
                if (diff == 1) {
                    deque.add(new int[]{i , count + 1});
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}