class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        // Count characters of s
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        if (solve(0, target, freq, ans)) {
            return ans.toString();
        }

        return "";
    }

    private boolean solve(int index, String target,
                          int[] freq, StringBuilder ans) {

        // We matched the entire target exactly.
        // But we need STRICTLY greater.
        if (index == target.length()) {
            return false;
        }

        int targetChar = target.charAt(index) - 'a';

        /*
         * CASE 1:
         * Try to keep current character equal to target.
         */
        if (freq[targetChar] > 0) {

            freq[targetChar]--;
            ans.append((char) ('a' + targetChar));

            if (solve(index + 1, target, freq, ans)) {
                return true;
            }

            // Backtrack
            ans.deleteCharAt(ans.length() - 1);
            freq[targetChar]++;
        }

        /*
         * CASE 2:
         * Try the smallest character greater than target[index].
         */
        for (int c = targetChar + 1; c < 26; c++) {

            if (freq[c] > 0) {

                freq[c]--;
                ans.append((char) ('a' + c));

                // Once greater, make suffix as small as possible.
                for (int x = 0; x < 26; x++) {

                    while (freq[x] > 0) {
                        ans.append((char) ('a' + x));
                        freq[x]--;
                    }
                }

                return true;
            }
        }

        return false;
    }
}