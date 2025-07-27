import java.util.Arrays;
import java.util.Collections;

class Solution {

    public int solution(
        int[] people,
        int limit
    ) {
        int answer = 0;
        Integer[] peopleBoxed = Arrays.stream(people)
            .boxed()
            .toArray(Integer[]::new);

        Arrays.sort(peopleBoxed, Collections.reverseOrder());
        int maxIndex = peopleBoxed.length - 1;

        for (int i = 0; i <= maxIndex; i++) {
            if (peopleBoxed[i] + peopleBoxed[maxIndex] <= limit) {
                maxIndex--;
            }
            answer++;
        }

        return answer;
    }
}
