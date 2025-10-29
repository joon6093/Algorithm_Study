import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[] arr = new boolean[10001];
        for(int i = 1; i<10001; i++) {
            int sum = 0;
            sum+= i;

            String num = String.valueOf(i);
            String[] numArr = num.split("");
            for (int j =0; j<numArr.length; j++) {
                sum +=Integer.valueOf(numArr[j]);
            }

            if (sum<10001) {
                arr[sum] = true;
            }
        }

        for(int i = 1; i<10001; i++) {
            if (arr[i]) {
                continue;
            }

            System.out.println(i);
        }
    }
}
