import java.io.*;
import java.util.*;

class Main {

    static List<List<Integer>> list;
    static int[] answer;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        list = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            list.add(new ArrayList<>());
        }
        answer = new int[N+1];

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            list.get(B).add(A);
        }

        for(int i=1; i<N+1; i++) {
            answer[i] = bfs(i);
        }

        int max = 0;
        for(int i=1; i<N+1; i++) {
            max = Math.max(max, answer[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N+1; i++) { 
            if(answer[i] == max) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    private static int bfs(int index) {
        boolean[] visited = new boolean[N+1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(index);
        visited[index] = true;
        int count = 0;
        while(!deque.isEmpty()) {
            int computer = deque.pollFirst();

            List<Integer> toComputers = list.get(computer);
            for(int i=0; i<toComputers.size(); i++) {   
                int toComputer = toComputers.get(i);
                if(visited[toComputer]) {
                    continue;
                }

                deque.add(toComputer);
                visited[toComputer] = true;
                count+=1;
            }
        }   

        return count;
    }
}
