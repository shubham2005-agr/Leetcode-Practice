class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrack(ans, new StringBuilder(), 0, 0, n);

        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder sb,
                           int open, int close, int n) {

        // A complete valid combination
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        // We can add '(' if we haven't used all opening brackets
        if (open < n) {
            sb.append('(');
            backtrack(ans, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        // We can add ')' only when it won't make the sequence invalid
        if (close < open) {
            sb.append(')');
            backtrack(ans, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}