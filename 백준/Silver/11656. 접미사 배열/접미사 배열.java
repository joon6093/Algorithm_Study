import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            result.add(S.substring(i));
        }
        result.stream().sorted().forEach(System.out::println);
    }
}
