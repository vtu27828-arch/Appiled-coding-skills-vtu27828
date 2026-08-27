import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision happens only when:
            // stack top is moving right and current is moving left
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {

                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    // Stack asteroid explodes
                    stack.pop();

                } else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    // Both explode
                    stack.pop();
                    destroyed = true;
                    break;

                } else {
                    // Current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}

Input
asteroids =
[5,10,-5]
Output
[5,10]
