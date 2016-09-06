import java.util.Stack;

public class Solution {
	public String decodeString(String s) {
		if (s.length() == 0)
			return "";
		// 用于存放整个字符串；
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		// 计算左括号；
		int left = 0;
		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);
			if (ch == ']') {
				// 退栈
				left--;
				// 得到重复的字符串；
				StringBuilder rep = new StringBuilder();
				while (stack.peek() != '[')
					rep.append(stack.pop());
				// 把'['弹栈；
				stack.pop();
				// 得到重复的次数；
				StringBuilder num = new StringBuilder();
				int iter = 0;
				while (!stack.isEmpty() && Character.isDigit(stack.peek()))
					num.append(stack.pop());
				// 注意需要翻转一下；
				iter = Integer.valueOf(num.reverse().toString());

				String s1 = rep.reverse().toString();

				// 如果还有左括号，就是嵌套的，先留着；
				if (left > 0) {
					for (int j = 0; j < iter; j++)
						for (int k = 0; k < rep.length(); k++)
							stack.add(s1.charAt(k));
					continue;
				}

				// 没有了，把这个字符串添加iter次；
				for (int j = 0; j < iter; j++)
					sb.append(s1);

			} else if (Character.isDigit(ch) || ch == '[')
				stack.add(ch);
			// 如果只有单独的字母，直接加入到最后的字符串中；
			else {
				if (stack.size() == 0)
					sb.append(ch);
				else
					stack.add(ch);
			}
			if (ch == '[')
				left++;
		}
		StringBuilder rest = new StringBuilder();
		
		// stack中还有剩余的？应该是没有了；
		while (!stack.isEmpty())
			rest.append(stack.pop());
		return sb.append(rest.reverse().toString()).toString();
	}

	public static void main(String[] args) {
		String s = "2[ab3[cd]]4[xy]";
		System.out.println(new Solution().decodeString(s));
	}
}
