class Solution {
    public String reverseParentheses(String s) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("");

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Start a new substring
                stack.push("");

            } else if (ch == ')') {
                // Get current substring
                String current = stack.pop();

                // Reverse it
                current = new StringBuilder(current).reverse().toString();

                // Add it to the previous level
                stack.push(stack.pop() + current);

            } else {
                // Add normal character
                stack.push(stack.pop() + ch);
            }
        }

        return stack.pop();
    }
}