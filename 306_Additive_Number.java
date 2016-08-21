public class Solution {
	String num;

	public boolean isAdditiveNumber(String num) {
		this.num = num;
		for (int i = 1; i < num.length(); i++) {
			if (num.charAt(0) == '0' && i >= 2)
				// 这里是可以直接返回false；
				return false;
			for (int j = i + 1; j < num.length(); j++) {
				if (num.charAt(i) == '0' && (j - i) >= 2)
					// 这里不是return false；因为还有i的机会，只能是break；
					break;
				// 使用Long
				// 注意出现02,这样被当成2的情况；
				Long num1 = Long.parseLong(num.substring(0, i));
				Long num2 = Long.parseLong(num.substring(i, j));
				if (check(num1, num2, j))
					return true;
			}
		}
		return false;
	}

	// 使用一个递归很有效果；
	private boolean check(Long num1, Long num2, int j) {
		// TODO Auto-generated method stub
		if (j == num.length())
			return true;
		Long num3 = num1 + num2;
		String num3String = num3.toString();
		if (j + num3String.length() > num.length())
			return false;
		if (num.substring(j, j + num3String.length()).equals(num3.toString()))
			return check(num2, num3, j + num3String.length());
		else
			return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String num = "198019823962";
		boolean flag = solution.isAdditiveNumber(num);
		System.out.println(flag);
	}
}
