import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < 12; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            lists.get(x).add(y);
            lists.get(y).add(x);
        }
        int answer = 0;
        for (int i = 0; i < 13; i++) {
            boolean one = false;
            boolean two = false;
            boolean three = false;
            if (lists.get(i).size() == 3) {
                for (int j : lists.get(i)) {
                    if (lists.get(j).size() == 3) {
                        three = true;
                    } else if (lists.get(j).size() == 2) {
                        two = true;
                    } else if (lists.get(j).size() == 1) {
                        one = true;
                    }
                }
            }
            if (one && two && three) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
