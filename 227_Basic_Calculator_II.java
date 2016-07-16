import java.util.Stack;

public class Solution {
	// 弹栈是因为计算的时机到了，不能再等了；
	public int calculate(String s) {
		Stack<Integer> sum = new Stack<Integer>();
		Stack<Character> op = new Stack<Character>();
		int i = 0, num = 0;
		char ch;
		while (i < s.length()) {
			num = 0;
			while (i < s.length() && s.charAt(i) == ' ')
				i++;
			if (i == s.length())
				break;
			ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {

				while (i < s.length() && (ch >= '0' && ch <= '9')) {
					num = num * 10 + ch - '0';
					i++;
					if (i < s.length())
						ch = s.charAt(i);
				}
				sum.push(num);
				continue;
			}

			if (!op.isEmpty()) {
				char chInStack = op.peek();
				switch (ch) {
				case '+':
				case '-':
					while (op.size() > 0) {
						chInStack = op.peek();
						if (chInStack == '*')
							sum.push(sum.pop() * sum.pop());
						else if (chInStack == '/') {
							int a = sum.pop();
							sum.push(sum.pop() / a);
						} else if (chInStack == '-')
							sum.push(-sum.pop() + sum.pop());
						else if (chInStack == '+')
							sum.push(sum.pop() + sum.pop());
						op.pop();
					}
					break;
				case '*':
				case '/':
					while (op.size() > 0 && (chInStack == '*' || chInStack == '/')) {
						if (chInStack == '*') {
							sum.push(sum.pop() * sum.pop());
						} else if (chInStack == '/') {
							int a = sum.pop();
							sum.push(sum.pop() / a);
						}
						op.pop();
						if (op.size() > 0)
							chInStack = op.peek();
					}
				default:
					break;
				}
			}
			op.push(ch);
			i++;

		}
		System.out.println(sum.toString());
		System.out.println(op.toString());
		while (op.size() > 0) {
			char ops = op.pop();
			switch (ops) {
			case '+':
				sum.push(sum.pop() + sum.pop());
				break;
			case '-':
				sum.push(-sum.pop() + sum.pop());
				break;
			case '*':
				sum.push(sum.pop() * sum.pop());
				break;
			case '/':
				int a = sum.pop();
				sum.push(sum.pop() / a);
				break;
			default:
				break;
			}
		}
		return sum.peek();
	}

	public static void main(String[] args) {
		String s = "2*3*4";
		System.out.println(new Solution().calculate(s));
	}
}
