import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] inputs = br.readLine().split("");
            for(int j=0; j<N; j++) {
                if(inputs[j].equals(".")) {
                    arr[i][j] = -1;
                } else {
                    arr[i][j] = Integer.parseInt(inputs[j]);
                }
            }
        }

        int[] dx = new int[]{1, 0, -1, 0, 1 , -1, -1, 1};
        int[] dy = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
        int[][] answer = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] != -1) {
                    answer[i][j] = -1;
                } else {
                    int count = 0;
                    for(int k=0; k<8; k++) {
                        int nextI = i + dx[k];
                        int nextJ = j + dy[k];

                        if(nextI < 0 || nextI > N-1 || nextJ < 0 || nextJ > N-1) {
                            continue;
                        }

                        if (arr[nextI][nextJ] != -1) {
                            count += arr[nextI][nextJ];
                        }
                    }

                    answer[i][j] = count;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(answer[i][j] == -1) {
                    System.out.print("*");
                } else {
                    if(answer[i][j] > 9) {
                        System.out.print("M");
                    } else {
                        System.out.print(answer[i][j]);
                    }
                }
            }

            System.out.println("");
        }
    }
}
