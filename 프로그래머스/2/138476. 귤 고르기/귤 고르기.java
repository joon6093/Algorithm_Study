import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(map.values());
        frequencies.sort((a, b) -> b - a);

        int kind = 0;
        for (int i = 0; i < frequencies.size(); i++) {
            if (k <= 0) {
                break;
            }

            k -= frequencies.get(i);
            kind++;
        }

        return kind;
    }
}
