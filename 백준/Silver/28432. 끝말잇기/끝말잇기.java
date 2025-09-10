import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        int index = list.indexOf("?");

        char leftWordLast = 0;
        char rightWordFirst = 0;

        if (index > 0) {
            leftWordLast = list.get(index - 1).charAt(list.get(index - 1).length() - 1);
        }
        if (index < list.size() - 1) {
            rightWordFirst = list.get(index + 1).charAt(0);
        }

        int M = Integer.parseInt(br.readLine());
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            list2.add(br.readLine());
        }

        for (String s : list2) {
            if (list.contains(s)) {
                continue;
            }

            if ((index == 0 || s.charAt(0) == leftWordLast) &&
                (index == list.size() - 1 || s.charAt(s.length() - 1) == rightWordFirst)) {
                System.out.println(s);
                return;
            }
        }
    }
}
