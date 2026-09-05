class Solution {

    public boolean uniformArray(int[] nums1) {
        if (nums1 == null || nums1.length == 0) {
            return true;
        }

        int mn = nums1[0];
        boolean hasOdd = false;
        for (int v : nums1) {
            if (v < mn) {
                mn = v;
            }
            if ((v & 1) == 1) {
                hasOdd = true;
            }
        }
        if ((mn & 1) == 1) {
            return true;
        }
        return !hasOdd;
    }
}
