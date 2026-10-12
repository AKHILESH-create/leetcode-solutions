import java.util.List;

class Solution {

    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        int[] cnt = new int[31];

        // Count how many numbers have each bit set.
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    cnt[bit]++;
                }
            }
        }

        long result = 0;
        for (int op = 0; op < k; op++) {
            long current = 0;

            // Build the largest possible number using the remaining bits.
            for (int bit = 30; bit >= 0; bit--) {
                if (cnt[bit] > 0) {
                    current |= (1L << bit);
                    cnt[bit]--;
                }
            }

            if (current == 0) break;
            result = (result + current * current) % MOD;
        }

        return (int) result;
    }
}
