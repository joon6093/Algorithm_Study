class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int pCount = 0;
        int yCount = 0;
        boolean answer = true;
        for(int i=0; i < s.length(); i++)
        {
            if (s.charAt(i) == 'p') {
                pCount+=1;
            }
            else if (s.charAt(i) == 'y') {
                yCount+=1;
            }
        }
        
        if (pCount != yCount) {
            answer = false;
        }

        return answer;
    }
}