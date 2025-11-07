import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int strikeOf(int a, int b, int c, int g1, int g2, int g3) {
        var s = 0;
        if (a == g1) s++;
        if (b == g2) s++;
        if (c == g3) s++;
        return s;
    }

    private static int ballOf(int a, int b, int c, int g1, int g2, int g3) {
        var bcnt = 0;
        if (a == g2 || a == g3) bcnt++;
        if (b == g1 || b == g3) bcnt++;
        if (c == g1 || c == g2) bcnt++;
        return bcnt;
    }

    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());

        var guess = new int[N][3];
        var S = new int[N];
        var B = new int[N];

        for (var i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            var g = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            guess[i][0] = g / 100;
            guess[i][1] = (g / 10) % 10;
            guess[i][2] = g % 10;
        }

        var answer = 0;

        for (var d1 = 1; d1 <= 9; d1++) {
            for (var d2 = 1; d2 <= 9; d2++) {
                if (d2 == d1) continue;
                for (var d3 = 1; d3 <= 9; d3++) {
                    if (d3 == d1) continue;
                    if (d3 == d2) continue;

                    var ok = true;
                    for (var i = 0; i < N; i++) {
                        var s = strikeOf(d1, d2, d3, guess[i][0], guess[i][1], guess[i][2]);
                        var b = ballOf(d1, d2, d3, guess[i][0], guess[i][1], guess[i][2]);
                        if (s != S[i]) ok = false;
                        if (b != B[i]) ok = false;
                        if (!ok) break;
                    }
                    if (ok) answer++;
                }
            }
        }

        System.out.println(answer);
    }
}