import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int L = Integer.parseInt(inputs[1]);

        int[][] arr = new int[L+1][2];
        for (int i =0; i< N; i ++) {
            String[] input = br.readLine().split(" ");
            int D = Integer.parseInt(input[0]);
            int R = Integer.parseInt(input[1]);
            int G = Integer.parseInt(input[2]);
            arr[D][0] = R;
            arr[D][1] = G;
        }
        
        int answer = 0;
        for (int i =1; i<L; i ++) {
            if (arr[i][0] == 0) {
                answer++;
                continue;
            }

            int R = arr[i][0];
            int G = arr[i][1];
            int temp = answer % (R + G);
            if (temp > R) {
                answer++;
            }else {
                answer += R - temp;
                answer++;
            }
        }

        System.out.println(answer);
    }    
}
