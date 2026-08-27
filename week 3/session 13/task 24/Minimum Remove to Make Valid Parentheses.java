class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } 
            else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*'); // mark invalid ')'
                }
            }
        }

        // Mark unmatched '('
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        // Build result
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '*') {
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }
}


Input
s =
"lee(t(c)o)de)"
Output
"lee(t(c)o)de"
