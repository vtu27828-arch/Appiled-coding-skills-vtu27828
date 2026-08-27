import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prev = stack.pop();
                answer[prev] = i - prev;
            }

            stack.push(i);
        }

        return answer;
    }
}

Input
temperatures =
[73,74,75,71,69,72,76,73]
Output
[1,1,4,2,1,1,0,0]
