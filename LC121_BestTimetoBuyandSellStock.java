public class LC121_BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int buyDate = -1;
        int sellDate = -1;
        int maxProfit = -1;

        for (int i = 0; i < prices.length - 1; i++){
            for (int j = i + 1; j < prices.length; j++){
                if (prices[j] - prices[i] > maxProfit){
                    buyDate = i;
                    sellDate = j;
                    maxProfit = prices[j] - prices[i];
                }
            }
        }

        if (maxProfit <= 0){
            maxProfit = 0;
        }
        return maxProfit;
    }

}
