public class Solution {
	public int lastRemaining(int n) {
		int iters = 1, end = n, pro = 2, nums = n;
		// pro指的是一趟完成之后数列的方差；是完成之后的方差；
		while (nums > 1) {
			// 从左向右
			if (iters % 2 == 1) {
				if (nums % 2 != 0)
					end = end - pro / 2;
			}
			// 从右向左；
			else {
				end = end - pro / 2;
			}
			System.out.println("end => " + end);
			iters++;
			pro = (int) Math.pow(2, iters);
			nums = nums / 2;
		}
		return end;
	}

	public static void main(String[] args) {
		int n = 19;
		System.out.println(new Solution().lastRemaining(n));
	}
}
