class Solution {
    public boolean uniformArray(int[] nums1) {

        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int x : nums1) {
            min = Math.min(min, x);

            if (x % 2 != 0) {
                hasOdd = true;
            }
        }

        // All numbers are even already
        if (!hasOdd) {
            return true;
        }

        // If odd numbers exist, minimum must be odd
        return min % 2 != 0;
    }
}