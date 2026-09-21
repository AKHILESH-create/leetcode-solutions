package Arrays.Medium;

class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int value : nums) {
            long[] ndp = new long[k];
            ndp[value % k] += 1L;

            for (int r = 0; r < k; r++) {
                if (dp[r] != 0) {
                    ndp[(int) (((long) r * value) % k)] += dp[r];
                }
            }

            dp = ndp;
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}
