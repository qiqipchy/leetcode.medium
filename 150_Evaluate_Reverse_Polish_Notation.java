import java.util.Stack;

public class Solution {
	// 后缀表达式求结果
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		int res = 0;
		if (tokens.length == 1)
			return Integer.parseInt(tokens[0]);
		for (int i = 0; i < tokens.length; i++) {
			if (!(tokens[i].equals("+") || tokens[i].equals("-")
					|| tokens[i].equals("*") || tokens[i].equals("/")))
				stack.push(Integer.parseInt(tokens[i]));
			else {
				switch (tokens[i].charAt(0)) {
				case '+':
					stack.push(stack.pop() + stack.pop());
					break;
				case '-':
					stack.push(-stack.pop() + stack.pop());
					break;
				case '*':
					stack.push(stack.pop() * stack.pop());
					break;
				case '/':
					int a = stack.pop();
					stack.push(stack.pop() / a);
					break;
				default:
					break;
				}
			}
		}
		return stack.peek();
	}

	public static void main(String[] args) {
		String[] tokens = { "4", "13", "5", "/", "+" };
		System.out.println(new Solution().evalRPN(tokens));
	}
}
