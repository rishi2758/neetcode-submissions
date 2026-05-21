class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = prices[n-1];
        int profit = 0;
        for (int end = n-2; end>=0;  end--) {
            profit = Math.max(profit, max - prices[end]);
            max = Math.max(max, prices[end]);
        }
        return profit;
    }
}
