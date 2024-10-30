class Solution {
    public int solution(String s) {
        int answer = 0;
        char str = 'x';
        int count = 0;
        
        for(int i=0; i<s.length(); i++) {
            if (count == 0) {
                str = s.charAt(i);
                count += 1;
                answer += 1;
            }
            else if (s.charAt(i) == str) {
                count += 1;
            }
            else {
                count -= 1;
            }
        }
        
        return answer;
    }
}