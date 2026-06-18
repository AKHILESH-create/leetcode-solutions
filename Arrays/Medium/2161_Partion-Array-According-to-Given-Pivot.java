import java.util.*;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int n = nums.length;
        int[] result = new int[n];
        int index = 0;

        // 1. elements less than pivot
        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            }
        }

        // 2. elements equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                result[index++] = num;
            }
        }

        // 3. elements greater than pivot
        for (int num : nums) {
            if (num > pivot) {
                result[index++] = num;
            }
        }

        return result;
    }
}
