class Solution {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] split = s.split("");
        int index = 0;
        
        for (String str : split) {
            if (str.equals(" ")) {
                answer.append(" ");
                index = 0;
            } else {
                if (index % 2 == 0) {
                    answer.append(str.toUpperCase());
                } else {
                    answer.append(str.toLowerCase());
                }
                index++;
            }
        }
        return answer.toString();
    }
}