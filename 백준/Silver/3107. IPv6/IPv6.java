import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(":", -1);
        List<String> list = new ArrayList<>();
        for (String s : inputs) {
            if ("".equals(s)) {
                if (!list.contains("temp")) {
                    list.add("temp");
                }
            } else {
                if (s.length() < 4) {
                    StringBuilder sb = new StringBuilder(s);
                    while (sb.length() < 4) {
                        sb.insert(0, "0");
                    }
                    list.add(sb.toString());
                } else {
                    list.add(s);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if ("temp".equals(list.get(i))) {
                int toAdd = 8 - list.size() + 1;
                for (int j = 0; j < toAdd; j++) {
                    sb.append("0000");
                    if (j != toAdd - 1) {
                        sb.append(":");
                    }
                }
            } else {
                sb.append(list.get(i));
            }
            if (i != list.size() - 1) {
                sb.append(":");
            }
        }

        System.out.println(sb);
    }
}
