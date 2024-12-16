import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> fibonacci = new ArrayList<>(List.of(0, 1));
        for (int i = 2; i < n+1; i++) {
            fibonacci.add((fibonacci.get(i - 1) + fibonacci.get(i - 2)) % 1234567);
        }
        return fibonacci.get(n);
    }
}