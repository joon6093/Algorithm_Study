class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int half = brown / 2;
        
        for (int i = half - 1 ; i > 2; i--) {
            int width= i;
            int height= half - i + 2;
            
            if ((width -2) * (height -2) == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        
        return answer;
    }
}