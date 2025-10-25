import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<List<String>, String> map = new HashMap<>();

        map.put(List.of(
                "***",
                "* *",
                "* *",
                "* *",
                "***"
        ), "0");

        map.put(List.of(
                "  *",
                "  *",
                "  *",
                "  *",
                "  *"
        ), "1");

        map.put(List.of(
                "***",
                "  *",
                "***",
                "*  ",
                "***"
        ), "2");

        map.put(List.of(
                "***",
                "  *",
                "***",
                "  *",
                "***"
        ), "3");

        map.put(List.of(
                "* *",
                "* *",
                "***",
                "  *",
                "  *"
        ), "4");

        map.put(List.of(
                "***",
                "*  ",
                "***",
                "  *",
                "***"
        ), "5");

        map.put(List.of(
                "***",
                "*  ",
                "***",
                "* *",
                "***"
        ), "6");

        map.put(List.of(
                "***",
                "  *",
                "  *",
                "  *",
                "  *"
        ), "7");

        map.put(List.of(
                "***",
                "* *",
                "***",
                "* *",
                "***"
        ), "8");

        map.put(List.of(
                "***",
                "* *",
                "***",
                "  *",
                "***"
        ), "9");
        
        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
        }

        int len = (arr[0].length() + 1) / 4;
        String number = "";
        for(int i=0; i<len; i++) {
            List<String> temp = new ArrayList<>();
            for (int j=0; j<5; j++) {
                temp.add(arr[j].substring(i * 4, i * 4 + 3));
            }
            if (!map.containsKey(temp)) {
                System.out.println("BOOM!!");
                return;
            }
            number += map.get(temp);
        }

        Integer numInteger = Integer.parseInt(number);
        if (numInteger % 6 != 0) {
            System.out.println("BOOM!!");
        }
        else {
            System.out.println("BEER!!");
        }
    }
}
