import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                prices[index] = prices[index] - prices[i];
            }

            stack.push(i);
        }

        return prices;
    }
}

Input
prices =
[8,4,6,2,3]
Output
[4,2,4,2,3]
