import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        while (N-- >0) {
            String[] inputs = br.readLine().split(" ");
            String s = inputs[0];
            String p = inputs[1];

            int index = 0;
            int count = 0;
            while(index < s.length()) {
                if (s.length() - index >=  p.length()) {
                    String temp = s.substring(index, index + p.length());
                    if (temp.equals(p)) {
                        count++;
                        index +=  p.length();
                        continue;
                    }
                }

                count++;
                index++;
            }

            System.out.println(count);
        }
    }
}
