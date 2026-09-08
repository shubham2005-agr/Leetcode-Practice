class Solution {
    public int countCommas(int n) {
        int ans = 0;

        // Numbers from 1,000 to n
        if (n >= 1000) {
            ans += n - 999;
        }

        // Additional comma for numbers from 1,000,000 to n
        if (n >= 1_000_000) {
            ans += n - 999_999;
        }

        // Additional comma for numbers from 1,000,000,000 to n
        if (n >= 1_000_000_000) {
            ans += n - 999_999_999;
        }

        return ans;
    }
}
