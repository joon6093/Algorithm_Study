import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<Integer> dq = new ArrayDeque<>();
            if (n > 0) {
                String[] arr = input.substring(1, input.length() - 1).split(",");
                for (String s : arr) dq.add(Integer.parseInt(s));
            }

            boolean reversed = false;
            boolean error = false;

            for (char c : p) {
                if (c == 'R') {
                    reversed = !reversed;
                } else if (c == 'D') {
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (reversed) dq.pollLast();
                    else dq.pollFirst();
                }
            }

            if (error) {
                sb.append("error\n");
                continue;
            }

            sb.append("[");
            if (!dq.isEmpty()) {
                if (reversed) {
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollLast());
                        if (!dq.isEmpty()) sb.append(",");
                    }
                } else {
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollFirst());
                        if (!dq.isEmpty()) sb.append(",");
                    }
                }
            }
            sb.append("]\n");
        }

        System.out.print(sb);
    }
}
