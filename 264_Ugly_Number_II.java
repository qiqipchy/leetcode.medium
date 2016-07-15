import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	// Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2
	// * 3, L3 * 5).
	// 先进先出，使用queue结构比list要好；
	Queue<Integer> two = new LinkedList<Integer>();
	Queue<Integer> three = new LinkedList<Integer>();
	Queue<Integer> five = new LinkedList<Integer>();

	public int nthUglyNumber(int n) {
		if (n <= 6)
			return n;
		int nums[] = new int[n];
		nums[0] = 1;
		two.add(2);
		three.add(3);
		five.add(5);
		int a2, a3, a5, min;
		for (int i = 1; i < n; i++) {
			a2 = two.peek();
			a3 = three.peek();
			a5 = five.peek();
			min = a2 < a3 ? (a2 < a5 ? a2 : a5) : (a3 > a5 ? a5 : a3);
			nums[i] = min;
			if (a2 == nums[i])
				two.poll();
			if (a3 == nums[i])
				three.poll();
			if (a5 == nums[i])
				five.poll();
			two.add(nums[i] * 2);
			three.add(nums[i] * 3);
			five.add(nums[i] * 5);
		}
		// System.out.println(Arrays.toString(nums));
		return nums[n - 1];
	}

	public static void main(String[] args) {
		int n = 12;
		System.out.println(new Solution().nthUglyNumber(n));
	}
}
