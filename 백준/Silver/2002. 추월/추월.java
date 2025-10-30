import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    
        Deque<String> deque = new ArrayDeque<>();
        for(int i =0; i<N; i++) {
            String car = br.readLine();
            deque.add(car);
        }

        Set<String> answer = new HashSet<>();
        for(int i =0; i<N; i++) {
            String car = br.readLine();
            if (car.equals(deque.peekFirst())) {
                deque.pollFirst();
                while(!deque.isEmpty() && answer.contains(deque.peekFirst())) {
                    deque.pollFirst();
                }
            } else {
                answer.add(car);
            }
        }

        System.out.println(answer.size());
    }
}
