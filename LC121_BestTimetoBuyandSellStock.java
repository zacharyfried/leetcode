public class LC121_BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 0;
        int maxProfit = 0;

        while (r < prices.length){
            if(prices[l] < prices[r]){
                int curProfit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, curProfit);
            } else {
                l = r;
            }
            r++;
        }
        return maxProfit;
    }

}
