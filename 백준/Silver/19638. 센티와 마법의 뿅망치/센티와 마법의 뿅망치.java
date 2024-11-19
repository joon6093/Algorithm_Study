import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long  H = Integer.parseInt(st.nextToken());
        long T = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)-> o2-o1);
        int count =0;
        for(int i=0; i<N; i++){
            queue.add(Integer.valueOf(br.readLine()));
        }
        for(int i=0; i<T;i++){
            if(queue.peek()<H || queue.peek()==1){
                break;
            }
            queue.add(queue.poll()/2);
            count++;
        }
        if(queue.peek()<H){
            System.out.println("YES");
            System.out.println(count);
        }
        else if(queue.peek()>=H){
            System.out.println("NO");
            System.out.println(queue.peek());
        }
    }
}