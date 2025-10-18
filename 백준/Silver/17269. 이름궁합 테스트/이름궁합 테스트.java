import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N  = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        inputs =  br.readLine().split(" ");
        String A = inputs[0];
        String B= inputs[1];    
        
        List<String> arr = new ArrayList<>();
        int max = Math.max(A.length(), B.length());
        for (int i = 0; i<max; i++) {
            if (A.length() > i) {
                arr.add(String.valueOf(A.charAt(i)));
            }

            if (B.length() > i) {
                arr.add(String.valueOf(B.charAt(i)));
            }
        }

        Map<String, Integer> point = new HashMap<>();
        point.put("A", 3);
        point.put("B", 2);
        point.put("C", 1);
        point.put("D", 2);
        point.put("E", 4);
        point.put("F", 3);
        point.put("G", 1);
        point.put("H", 3);
        point.put("I", 1);
        point.put("J", 1);
        point.put("K", 3);
        point.put("L", 1);
        point.put("M", 3);
        point.put("N", 2);
        point.put("O", 1);
        point.put("P", 2);
        point.put("Q", 2);
        point.put("R", 2);
        point.put("S", 1);
        point.put("T", 2);
        point.put("U", 1);
        point.put("V", 1);
        point.put("W", 1);
        point.put("X", 2);
        point.put("Y", 2);
        point.put("Z", 1);

        List<Integer> list = new ArrayList<>();
        for(int i =0; i< arr.size(); i++){
            list.add(point.get(arr.get(i)));
        }

        while (list.size() > 2) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                temp.add((list.get(i) + list.get(i + 1)) % 10);
             }
        list = temp;
        
}
        String answer = String.valueOf(list.get(0) * 10 + list.get(1));
        System.out.println(answer + "%");
    }
}
