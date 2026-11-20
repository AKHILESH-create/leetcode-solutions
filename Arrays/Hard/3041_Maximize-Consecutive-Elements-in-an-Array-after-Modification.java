class Solution {

    public int maxSelectedElements(int[] nums) {
        java.util.Arrays.sort(nums);
        java.util.Map<Integer, Integer> dp = new java.util.HashMap<>();
        int ans = 0;
        for (int x : nums) {
            dp.put(
                x + 1,
                Math.max(dp.getOrDefault(x + 1, 0), dp.getOrDefault(x, 0) + 1)
            );
            dp.put(
                x,
                Math.max(dp.getOrDefault(x, 0), dp.getOrDefault(x - 1, 0) + 1)
            );
            ans = Math.max(ans, Math.max(dp.get(x), dp.get(x + 1)));
        }
        return ans;
    }
}