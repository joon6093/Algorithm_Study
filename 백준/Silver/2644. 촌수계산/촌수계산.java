import java.io.*;
import java.util.*;

class Main {

    static List<List<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i =0; i<n+1; i++) {
            list.add(new ArrayList<>());      
        }
        visited = new boolean[n+1];

        String[] inputs = br.readLine().split(" ");
        Integer start = Integer.parseInt(inputs[0]);
        Integer end = Integer.parseInt(inputs[1]);

        Integer m = Integer.parseInt(br.readLine());
        for(int i =0; i<m; i++) {
           inputs = br.readLine().split(" ");
           Integer parent = Integer.parseInt(inputs[0]);
           Integer child = Integer.parseInt(inputs[1]);
           list.get(parent).add(child);
           list.get(child).add(parent);
        }

        int answer = bfs(start, end);
        System.out.println(answer);
    }

    private static int bfs(int start, int end) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{start, 0});
        visited[start] = true;
        while(!deque.isEmpty()) {
            if (deque.peekFirst()[0] == end) {
                break;
            }
            int[] next = deque.pollFirst();
            List<Integer> temp = list.get(next[0]);
            for (int i = 0; i<temp.size(); i++) {
                int tempNum = temp.get(i);
                if (visited[tempNum]) {
                    continue;
                }
                deque.add(new int[]{tempNum, next[1]+1});
                visited[tempNum] = true;
            }
        }
        
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst()[1];
    }
        
}
