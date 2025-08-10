import java.util.Arrays;

class Solution {

    public int solution(
        int[] arrayA,
        int[] arrayB
    ) {
        int answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        boolean isGcdAValid = true;
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcdA == 0) {
                isGcdAValid = false;
                break;
            }
        }

        boolean isGcdBValid = true;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdB == 0) {
                isGcdBValid = false;
                break;
            }
        }
        if (isGcdAValid) {
            answer = Math.max(answer, gcdA);
        }

        if (isGcdBValid) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    public static int gcd(
        int a,
        int b
    ) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
