class Solution {

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = last index in word1 where word2[j] occurs
        int[] last = new int[m];

        for (int j = 0; j < m; j++) {
            last[j] = -1;
        }

        // Find the last possible position for every character of word2
        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        // We can use at most one mismatch
        boolean usedMismatch = false;

        i = 0;
        j = 0;

        while (i < n && j < m) {

            // Case 1: Characters are equal
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Case 2: Use this position as the one mismatch
            else if (!usedMismatch) {

                /*
                 * We can use i as the mismatching character if:
                 *
                 * 1. j is the last character of word2
                 *    OR
                 *
                 * 2. All remaining characters of word2 can still
                 *    be matched after i.
                 *
                 * last[j + 1] tells us the last possible position
                 * for word2[j + 1].
                 */
                if (j == m - 1 || i < last[j + 1]) {

                    ans[j] = i;
                    j++;

                    usedMismatch = true;
                }
            }

            i++;
        }

        // Could not match all characters
        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}