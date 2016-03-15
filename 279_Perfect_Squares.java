public class Solution {
	public int numSquares(int n) {
		int[] res = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int s = (int) Math.sqrt(i);
			if (s * s == i)
				res[i] = 1;
			else {
				int min = Integer.MAX_VALUE;
				// 注意，这里如果是j<i的话就重复了，所以是到一半的时候；
				for (int j = 1; j < i / 2 + 1; j++)
					min = Math.min(min, res[j] + res[i - j]);
				res[i] = min;
			}
		}
		return res[n];
	}

	public static void main(String[] args) {
		int n = 13;
		System.out.println(new Solution().numSquares(n));
	}
}
