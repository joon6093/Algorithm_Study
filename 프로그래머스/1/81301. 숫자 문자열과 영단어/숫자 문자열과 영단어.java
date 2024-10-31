class Solution {
    public int solution(String s) {
         String[] strNums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i=0; i<strNums.length; i++) {
            if (s.contains(strNums[i])) {
                s= s.replace(strNums[i], Integer.toString(i));
            }
        }
     
        int answer=  Integer.parseInt(s);
        return answer;
    }
}