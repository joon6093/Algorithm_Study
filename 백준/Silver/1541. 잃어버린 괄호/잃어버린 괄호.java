import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("-");
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].contains("+")) {
                String[] temps = inputs[i].split("\\+");
                int result = 0;
                for (String temp : temps) {
                    int num = Integer.parseInt(temp);
                    result += num;
                }
                inputs[i] = result + "";
            }
        }

        int answer = Integer.parseInt(inputs[0]);
        for (int i = 1; i < inputs.length; i++) {
            answer -= Integer.parseInt(inputs[i]);
        }
        System.out.println(answer);
    }
}
