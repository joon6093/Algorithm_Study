class Solution {
    public int solution(String t, String p) {
        int lenP = p.length();
        long longP = Long.parseLong(p);
        int answer = 0;
        
        for(int i=0; i<t.length()-lenP+1; i++) {
            String subT = t.substring(i, i+lenP);
            Long longT = Long.parseLong(subT);
            if (longT <= longP) {
                answer+=1;
            }
        }
        
        return answer;
    }
}