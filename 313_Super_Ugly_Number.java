import java.util.Arrays;

public class Solution {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] idx = new int[primes.length];
		Arrays.fill(idx, 1);
		int[] res = new int[n + 1];
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			res[i] = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				if (res[idx[j]] * primes[j] < res[i]
						&& res[idx[j]] * primes[j] > res[i - 1]) {
					res[i] = res[idx[j]] * primes[j];
				}
			}
			// 会出现相同的值，例如说7*5=5*7,那么5和7都应该到下一位了；
			for (int j = 0; j < primes.length; j++) {
				if (res[i] % primes[j] == 0)
					idx[j]++;
			}
		}
		//System.out.println(Arrays.toString(res));
		return res[n];
	}

	public static void main(String[] args) {
		new Solution().nthSuperUglyNumber(15, new int[] { 3, 5, 7, 11, 19, 23,
				29, 41, 43, 47 });
	}
}
