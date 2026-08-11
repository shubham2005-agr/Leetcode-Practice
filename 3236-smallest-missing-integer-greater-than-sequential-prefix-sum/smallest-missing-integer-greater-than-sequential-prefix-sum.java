import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {

        int n = nums.length;

        // Find sum of longest sequential prefix
        int sum = nums[0];

        for (int i = 1; i < n; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Store all elements
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Find smallest missing integer >= sum
        int x = sum;

        while (set.contains(x)) {
            x++;
        }

        return x;
    }
}