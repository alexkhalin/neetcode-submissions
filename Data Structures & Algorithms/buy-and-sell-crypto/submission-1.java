class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int localMin = prices[0];
        for (int price: prices) {
            if (price < localMin) {
                localMin = price;
            } else {
                maxProfit = Math.max(maxProfit, price - localMin);
            }
        }
        return maxProfit;
    }
}
