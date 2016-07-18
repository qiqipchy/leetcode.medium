import java.util.ArrayList;
import java.util.List;

public class Solution {

	public String fractionToDecimal(int numerator, int denominator) {
		long mnumerator, mdenominator;
		mnumerator = numerator;
		mdenominator = denominator;
		// 注意使用long类型的，中间有超过int类型的计算；
		return cal(mnumerator, mdenominator);
	}

	public String cal(long numerator, long denominator) {
		List<Long> list = new ArrayList<Long>();
		// 整除，直接返回就可以了；
		if (numerator % denominator == 0)
			return String.valueOf(numerator / denominator);
		int flag = 1;
		// 看是不是正数；
		if ((numerator > 0 && denominator < 0)
				|| (numerator < 0 && denominator > 0)) {
			flag = 0;
		}
		// 保证都是正数；
		if (numerator < 0)
			numerator *= -1;
		if (denominator < 0)
			denominator *= -1;
		// System.out.println(denominator);

		int res = 0, indexForCur = -1;
		StringBuilder fraction = new StringBuilder();
		res = (int) (numerator / denominator);
		fraction.append(res + ".");
		// 为以后插入括号准备
		int length = fraction.length();
		numerator = numerator % denominator;
		list.add(numerator);

		while (true) {
			fraction.append(numerator * 10 / denominator);
			numerator = numerator * 10 % denominator;
			if (numerator == 0)
				break;
			if ((indexForCur = list.indexOf(numerator)) != -1)
				break;
			list.add(numerator);
		}
		if (indexForCur != -1) {
			fraction.insert(indexForCur + length, '(');
			fraction.append(")");
		}
		return flag == 1 ? fraction.toString() : "-" + fraction.toString();
	}


	public static void main(String[] args) {
		int numerator = -1;
		int denominator = -2147483648;
		System.out.println(new Solution().fractionToDecimal(numerator,
				denominator));
	}
}
