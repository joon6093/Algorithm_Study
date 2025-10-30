import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i<N+1; i++) {
            deque.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!deque.isEmpty()) {
            for (int i =0; i<K-1; i++) {
                int remove =deque.pollFirst();
                deque.add(remove);
            }
            ans.add(deque.pollFirst());
        }

        System.out.print("<");
        for(int i =0; i<ans.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(ans.get(i));
        }
        System.out.print(">");
    }
}
