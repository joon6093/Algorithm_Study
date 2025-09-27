import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            String name = inputs[0];
            String status = inputs[1];
            if (status.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        List<String> names = new ArrayList<>(set);
        Collections.sort(names, Collections.reverseOrder());
        for (String name : names) {
            System.out.println(name);
        }
    }
}
