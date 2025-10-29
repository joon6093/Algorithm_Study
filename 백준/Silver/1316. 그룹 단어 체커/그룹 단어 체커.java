import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            Set<String> set = new HashSet<>();
            String prev = "";
            boolean isGroupWord = true;

            for (int j = 0; j < input.length; j++) {
                if (!prev.equals(input[j])) {
                    if (set.contains(input[j])) {
                        isGroupWord = false;
                        break;
                    }
                }
                set.add(input[j]);
                prev = input[j];
            }

            if (isGroupWord) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
