import java.util.Arrays;

class Solution {

    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        int currentEnd = 0;
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            if (start >= currentEnd) {
                answer++;
                currentEnd = end;
            }
        }
        return answer;
    }
}
