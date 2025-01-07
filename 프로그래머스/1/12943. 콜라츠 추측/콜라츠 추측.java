class Solution {

    public int solution(long num) {
        int answer = 0;

        if (num == 1) {
            return 0;
        }

        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
                answer = answer + 1;
            }
            else if (num % 2 != 0) {
                num = num * 3 + 1;
                answer = answer + 1;
            }
            if (num == 1) {
                break;
            }

            if (answer == 500) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}