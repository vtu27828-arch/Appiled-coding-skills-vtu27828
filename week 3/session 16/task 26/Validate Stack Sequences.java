import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int value : pushed) {

            // Push the element
            stack.push(value);

            // Pop whenever the top matches popped[j]
            while (!stack.isEmpty() && j < popped.length
                    && stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        // All elements must have been popped
        return j == popped.length;
    }
}

Input
pushed =
[1,2,3,4,5]
popped =
[4,5,3,2,1]
Output
true
