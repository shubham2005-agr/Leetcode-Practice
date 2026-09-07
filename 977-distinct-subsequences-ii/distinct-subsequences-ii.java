class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[26];

        for (char c : s.toCharArray()) {
            int total = 1;

            for (int x : dp) {
                total = (total + x) % MOD;
            }

            dp[c - 'a'] = total;
        }

        int ans = 0;
        for (int x : dp) {
            ans = (ans + x) % MOD;
        }

        return ans;
    }
}