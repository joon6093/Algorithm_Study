import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int country = Integer.parseInt(input[0]);
            int number = Integer.parseInt(input[1]);
            int point = Integer.parseInt(input[2]);
            int[] arr = new int[3];
            arr[0] = country;
            arr[1] = number;
            arr[2] = point;
            list.add(arr);
        }

        list.sort((o1, o2) -> {
            if (o1[2] == o2[2]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o2[2], o1[2]);
            }
        });

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (result.size() == 3) {
                break;
            }
            int[] curr = list.get(i);
            int count = 0;
            for (int[] res : result) {
                if (res[0] == curr[0]) {
                    count++;
                }
            }
            if (count < 2) {
                result.add(curr);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] res : result) {
            sb.append(res[0]).append(" ").append(res[1]).append("\n");
        }

        System.out.print(sb);
    }
}
