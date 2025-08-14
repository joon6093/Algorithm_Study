class Solution {
    public int[] solution(final int[] sequence, final int k) {
        final int n = sequence.length;
        int left = 0;
        long sum = 0L;

        int bestL = 0;
        int bestR = n - 1;
        boolean found = false;

        for (int right = 0; right < n; right++) {
            sum += sequence[right];

            while (sum > k && left <= right) {
                sum -= sequence[left++];
            }

            if (sum == k) {
                if (!found
                        || (right - left) < (bestR - bestL)
                        || ((right - left) == (bestR - bestL) && left < bestL)) {
                    bestL = left;
                    bestR = right;
                    found = true;
                }
            
                sum -= sequence[left++];
            }
        }

        return new int[]{bestL, bestR};
    }
}
