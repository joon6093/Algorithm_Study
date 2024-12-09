import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder answer = new StringBuilder();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (" ".equals(token)) {
                answer.append(" ");
            } else {
                answer.append(token.substring(0, 1).toUpperCase()).append(token.substring(1).toLowerCase());
            }
        }

        return answer.toString();
    }
}
