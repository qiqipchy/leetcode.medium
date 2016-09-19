import java.util.Stack;

public class Solution {
	boolean[] visit;
	public String removeKdigits(String num, int k) {
		if (k >= num.length())
			return "0";
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		int i = 0, cnt = 0;
		while (i < num.length() && cnt < k) {
			char ch = num.charAt(i++);
			if (stack.isEmpty())
				stack.add(ch);

			else {
				// 去掉逆序的；
				while (!stack.isEmpty() && stack.peek() > ch) {
					stack.pop();
					cnt++;
					if (cnt == k)
						break;
				}
				stack.push(ch);
			}
		}
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();
		sb.append(num.substring(i));
		String res = sb.toString();
		i = 0;

		while (i < res.length())
			if (res.charAt(i) != '0')
				break;
			else
				i++;
		// 如果剩下的全部是0；
		if (i == res.length())
			return "0";
		// 如果逆序的少于cnt个，还需要补，k-cnt个；
		return res.substring(i, res.length() - (k - cnt));
	}
	public static void main(String[] args) {
		String num = "1111111";
		int k = 3;
		System.out.println(new Solution().removeKdigits(num, k));
	}
}
