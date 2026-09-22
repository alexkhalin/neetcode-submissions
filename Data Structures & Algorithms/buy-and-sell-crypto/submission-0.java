class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int localMin = prices[0];
        int localMax = localMin;
        for (int price: prices) {
            localMax = Math.max(localMax, price);
            if (price < localMin) {
                maxProfit = Math.max(maxProfit, localMax - localMin);
                localMin = price;
                localMax = localMin;
            }
        }
        return Math.max(maxProfit, localMax - localMin);
    }
}
