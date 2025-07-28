import java.util.Arrays;

class Solution {

    public int[] solution(
        int n,
        String[] words
    ) {
        int[] answer = {0, 0};

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i > 0) {
                String prevWord = words[i - 1];
                if (prevWord.charAt(prevWord.length() - 1) != word.charAt(0) ||
                    Arrays.asList(words).subList(0, i).contains(word)) {
                    answer = new int[]{i % n + 1, i / n + 1};
                    break;
                }
            }
        }

        return answer;
    }
}
