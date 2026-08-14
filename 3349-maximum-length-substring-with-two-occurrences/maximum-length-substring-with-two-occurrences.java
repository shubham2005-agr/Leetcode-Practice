import java.util.*;

class Solution {
    public int maximumLengthSubstring(String s) {

        int left = 0;
        int ans = 0;

        int[] freq = new int[256];

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freq[ch]++;

            // If any character occurs more than twice,
            // shrink the window
            while (freq[ch] > 2) {
                freq[s.charAt(left)]--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}