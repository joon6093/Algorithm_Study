import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int A = Integer.parseInt(inputs[0]);
            int B = Integer.parseInt(inputs[1]);

            System.out.println(A * B / gcd(A, B));
        }
    }

    private static int gcd(int A, int B) {
        int min = Math.min(A, B);

        int gcd = 1;
        for(int i=1; i<=min; i++) {
            if (A % i ==0 && B % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }
}
