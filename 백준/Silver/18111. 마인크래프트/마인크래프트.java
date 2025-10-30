import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int B = Integer.parseInt(inputs[2]);

        int[][] arr = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i<N; i++) {
            inputs = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int minCost = Integer.MAX_VALUE;
        int height = 0;
        for(int i=min; i<=max; i++) {
            // System.out.println(i);
            int cost = cal(arr, i, B);
            if (cost ==  Integer.MAX_VALUE) {
                continue;
            }
            if (cost<minCost) {
                minCost = cost;
                height = i;
            } else if(cost==minCost) {
                if(i>height) {
                    minCost = cost;
                    height = i;
                }
            }
        }
        
        System.out.print(minCost + " ");
        System.out.print(height);
    }

    private static int cal(int[][] arr, int goal, int box) {
        int cost = 0;
        for (int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                int current = arr[i][j];
                if (current > goal) {
                    int temp = (current - goal);
                    cost += temp * 2;
                    box += temp;
                }

                if (goal > current) {
                    int temp = goal - current;
                    cost += temp;
                    box -= temp;
                }
            }
        }
 
        if (box < 0) {
            return Integer.MAX_VALUE;
        }
        return cost;
    }
}
