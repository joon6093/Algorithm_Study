class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if (s.length() == 1) return 1;

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int count = 1;

            for (int j = i; j + i <= s.length(); j += i) {
                String current = s.substring(j, j + i);
                if (current.equals(prev)) {
                    count++;
                    continue;
                }
                if (count > 1) sb.append(count);
                sb.append(prev);
                prev = current;
                count = 1;
            }

            // 마지막 처리
            if (count > 1) sb.append(count);
            sb.append(prev);

            // 나머지 붙이기
            int remain = s.length() % i;
            if (remain != 0) {
                sb.append(s.substring(s.length() - remain));
            }

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
