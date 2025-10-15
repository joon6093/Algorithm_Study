import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }   
        
        List<String> temp = new ArrayList<>(list);
        Collections.sort(temp);

        if (list.equals(temp)) {
            System.out.println("INCREASING");
            return;
        }
        Collections.sort(temp, Collections.reverseOrder());
        if (list.equals(temp)) {
            System.out.println("DECREASING");
            return;
        }
         System.out.println("NEITHER");
    }
}
