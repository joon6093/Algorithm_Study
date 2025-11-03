import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean isTag = false;

        Deque<Character> deque = new ArrayDeque<>();
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(c == '<') {
                while(!deque.isEmpty()) {
                    char temp = deque.pollLast();
                    System.out.print(temp);
                }

                isTag = true;
            }

            if(isTag) {
                System.out.print(c);
                if (c == '>') {
                    isTag = false;
                }
                continue;
            }

            if(c == ' ') {
                while(!deque.isEmpty()) {
                    char temp = deque.pollLast();
                    System.out.print(temp);
                }
                System.out.print(c);
                continue;
            }

            if(i == input.length() -1) {
                System.out.print(c);
                while(!deque.isEmpty()) {
                    char temp = deque.pollLast();
                    System.out.print(temp);
                }
                continue;
            }

            deque.add(c);
        }
    }
}
