class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int l = 0;
        int r = 1;
        int profit = 0;
        while (r < n) {
            if (prices[l] < prices[r]) {
                profit = Math.max(profit, prices[r]-prices[l]);
            } else {
                l = r;
            }
            ++r;
        }
        return profit;
    }
}
