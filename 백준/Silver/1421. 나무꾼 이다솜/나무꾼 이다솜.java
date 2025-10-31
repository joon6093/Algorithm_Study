import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);
        int W = Integer.parseInt(inputs[2]);

        int[] arr = new int[N];
        int max = 0;
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }   

        long maxPrice = 0;
        for(int i=1; i<max+1; i++) {
            long currnetPrice = 0;
            for(int j=0; j<N; j++) {
                if(i>arr[j]) {
                    continue;
                }
                int size = arr[j] / i;
                int cut = 0;
                if (arr[j] % i == 0) {
                    cut = size - 1;
                } else {
                    cut = size;
                }

                currnetPrice += Math.max((size * i * W) - (cut * C), 0);
            }
            maxPrice = Math.max(maxPrice, currnetPrice);
        } 

        System.out.println(maxPrice);
    }
}
