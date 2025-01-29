class Solution {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int index = s.substring(0, i).lastIndexOf(s.charAt(i));
            if (index == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - index;
            }
        }
        return answer;
    }
}