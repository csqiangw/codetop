public class _15_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int min = prices[0],profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - min > profit)
                profit = prices[i] - min;
            if(prices[i] < min)
                min = prices[i];
        }
        return profit;
    }

}
