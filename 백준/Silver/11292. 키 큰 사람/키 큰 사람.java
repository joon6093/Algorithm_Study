import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            List<String> list = new ArrayList<>();
            double maxHeight = 0.0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());

                if (height > maxHeight) {
                    maxHeight = height;
                    list.clear();
                    list.add(name);
                } else if (height == maxHeight) {
                    list.add(name);
                }
            }

            for (String name : list) {
                sb.append(name).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
