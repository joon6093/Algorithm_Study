import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> weightCount = new HashMap<>();
        Arrays.sort(weights);

        for (int weight : weights) {
            double a = (double) weight;
            double b = (double) (weight * 2) / 4;
            double c = (double) (weight * 2) / 3;
            double d = (double) (weight * 3) / 4;
            if (weightCount.containsKey(a)) {
                answer += weightCount.get(a);
            }
            if (weightCount.containsKey(b)) {
                answer += weightCount.get(b);
            }
            if (weightCount.containsKey(c)) {
                answer += weightCount.get(c);
            }
            if (weightCount.containsKey(d)) {
                answer += weightCount.get(d);
            }

            weightCount.put((double) weight, weightCount.getOrDefault((double) weight, 0) + 1);
        }
        
        return answer;
    }
}
