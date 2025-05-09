import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 동전 개수 저장
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int x = Integer.parseInt(br.readLine());
            arr.add(x);
        }

        // 큰 값어치의 동전부터 빠르게 쳐내기
        // 10원 열 개보다 100원 한 개 쓰면 더 적으니까
        Collections.sort(arr, Collections.reverseOrder());
        int result = 0;
        for (int i : arr) {
            int need = m / i;  // 현재 동전 몇개를 써야 최대한 줄일 수 있는가에서 `개수` 구하기
            m = m % i;         // 현재 동전으로 쳐내지 못한 나머지 구하기
            result += need;    // 현재 동전 사용한 개수 더하기
        }
        bw.write(result + "\n");

        br.close();
        bw.close();
    }
}
