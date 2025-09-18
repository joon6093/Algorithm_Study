import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split("");
        int count = 0;
        for (int i = 1; i < inputs.length + 1; i++) {
            if (inputs[i - 1].equals("Y")) {
                count++;
                for (int j = i; j < inputs.length + 1; j += i) {
                    inputs[j - 1] = inputs[j - 1].equals("Y") ? "N" : "Y";
                }
            }
        }

        System.out.println(count);
    }
}
