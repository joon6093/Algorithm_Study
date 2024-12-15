class Solution {
    public int solution(int n) {
        int nBitCount = Integer.bitCount(n);

        while(true){
            n++;
            int nNextCount = Integer.bitCount(n);

            if(nBitCount == nNextCount){
                 return n;
            }
        }
    }
}