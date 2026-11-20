import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long operations = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(
            Comparator.<int[]>comparingInt(a -> a[0]).reversed()
        );

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] covered = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            covered[i] = new ArrayList<>();
        }

        int[] nextGreaterOrEqual = new int[n];
        java.util.Arrays.fill(nextGreaterOrEqual, n);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int left = 0, right = 0; right < n; right++) {
            while (!stack.isEmpty() && nums[right] >= nums[stack.peek()]) {
                nextGreaterOrEqual[stack.peek()] = right;
                stack.pop();
            }

            if (!stack.isEmpty()) {
                covered[stack.peek()].add(right);
            }
            stack.push(right);

            queue.offer(new int[]{nums[right], right});
            operations += Math.max(0L,
                (long) queue.peek()[0] - (long) nums[right]);

            while (operations > k) {
                for (int i : covered[left]) {
                    operations -= (long) (nums[left] - nums[i])
                        * (Math.min(nextGreaterOrEqual[i], right + 1) - i);
                }
                left++;
            }

            while (!queue.isEmpty() && queue.peek()[1] < left) {
                queue.poll();
            }

            ans += (long) (right - left + 1);
        }

        return ans;
    }
}