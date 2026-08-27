import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Store opening brackets
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            // Check closing brackets
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        // Valid only if no opening brackets remain
        return stack.isEmpty();
    }
}

Input
s =
"()"
Output
true
