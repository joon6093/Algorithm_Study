class Solution {

    public long solution(
        int r1,
        int r2
    ) {
        long R1 = r1;
        long R2 = r2;
        long count = 0;

        for (long x = 1; x <= R2; x++) {
            long yMax = (long) Math.floor(Math.sqrt(R2 * R2 - x * x));
            long inner = R1 * R1 - x * x;
            
            long yMin;
            if (inner > 0) {
                yMin = (long) Math.ceil(Math.sqrt(inner));
            } else {
                yMin = 0L;
            }

            if (yMax >= yMin) {
                count += (yMax - yMin + 1);
            }
        }

        return count * 4;
    }
}
