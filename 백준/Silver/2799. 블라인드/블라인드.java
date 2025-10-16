import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        String[][] arr = new String[5*M+1][5*N+1];
           for (int i = 0; i < 5*M+1; i ++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 5*N+1; j++) {
                arr[i][j] = input[j];
            }
        }

        int[] answer = new int[5];
        for (int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j++) {
                if (arr[5*i+1][5*j+1].equals("*")) {
                    if (arr[5*i+2][5*j+1].equals("*")) {
                        if (arr[5*i+3][5*j+1].equals("*")) { 
                            if (arr[5*i+4][5*j+1].equals("*")) { 
                                answer[4]++;
                            }
                            else {
                                answer[3]++;
                            }
                        } else {
                             answer[2]++;
                        }
                    } else {
                        answer[1]++;
                    }
                }
                else {
                    answer[0]++;
                }
            }
        }

        System.out.print(answer[0]);
        System.out.print(" ");
        System.out.print(answer[1]);
        System.out.print(" ");
        System.out.print(answer[2]);
        System.out.print(" ");
        System.out.print(answer[3]);
        System.out.print(" ");
        System.out.print(answer[4]);
    }
}
