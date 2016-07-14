import java.util.Arrays;

public class Solution {
	public int coinChange(int[] coins, int amount) {
		// res[1]为amount为1时最小的。
		Arrays.sort(coins);
		if (amount <= 0)
			return 0;
		if (coins.length == 0 || amount < coins[0])
			return -1;
		int cnt = 0;
		while (cnt < coins.length && coins[cnt] <= amount)
			cnt++;
		int[] res = new int[amount + 1];
		for (int i = 0; i < cnt; i++) {
			res[coins[i]] = 1;
			if (coins[i] == amount)
				return 1;
		}
		for (int i = 1; i <= amount; i++) {
			if (res[i] == 0)
				res[i] = Integer.MAX_VALUE;
			//这里使用的条件是决定用哪一枚硬币；
			for (int j = 0; j < coins.length; j++) {
				if (i > coins[j]) {
					if (res[i - coins[j]] != Integer.MAX_VALUE)
						res[i] = Math.min(res[i], res[i - coins[j]] + 1);
				}
			}
		}
		return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];

	}

	public static void main(String[] args) {
		int coins[] = { 1, 3 };
		int amount = 11245;
		System.out.println(new Solution().coinChange(coins, amount));
	}
}
