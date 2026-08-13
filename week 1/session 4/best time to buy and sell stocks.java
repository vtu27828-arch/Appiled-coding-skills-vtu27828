class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Find the lowest buying price
            minPrice = Math.min(minPrice, price);

            // Calculate profit if we sell today
            int profit = price - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}

Input
prices =
[7,1,5,3,6,4]
Output
5
