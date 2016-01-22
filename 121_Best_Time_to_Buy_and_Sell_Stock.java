public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int i = 1, min = prices[0], max = 0;
		while (i < prices.length) {
			if (prices[i] < prices[i - 1]) {
				max = Math.max(prices[i - 1] - min, max);
				min = Math.min(min, prices[i]);
			}
			i++;
		}
		max = Math.max(prices[i - 1] - min, max);
		return max;
	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 2, 3, 2, 4, 5, 6, 19, 7, 45 };
		System.out.println(new Solution().maxProfit(prices));
	}
}
