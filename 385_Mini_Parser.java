import java.util.List;
import java.util.Stack;

//This is the interface that allows for creating nested lists.
//You should not implement it, or speculate about its implementation
class NestedInteger {
	// Constructor initializes an empty nested list.
	public NestedInteger() {
	}

	// Constructor initializes a single integer.
	public NestedInteger(int value) {
	}

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger() {
	}

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
	}

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value) {
	}

	// Set this NestedInteger to hold a nested list and adds a nested integer to
	// it.
	public void add(NestedInteger ni) {
	}

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
	}
}

public class Solution {
	public NestedInteger deserialize(String s) {
		if (s.length() == 0)
			return null;
		if (!s.contains("["))
			return new NestedInteger(Integer.parseInt(s));

		Stack<NestedInteger> stack = new Stack<NestedInteger>();
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (ch == '[') {
				stack.add(new NestedInteger());
			} else if (ch == '-' || (ch >= '0' && ch <= '9')) {
				int num = 0, sign = 1;
				if (ch == '-') {
					sign = -1;
					i++;
					ch = s.charAt(i);
				}
				while (ch >= '0' && ch <= '9') {
					// System.out.println(ch);
					num = num * 10 + ch - '0';
					i++;
					// ch要放在最后；
					ch = s.charAt(i);
				}
				num = num * sign;
				// System.out.println(num);

				stack.peek().add(new NestedInteger(num));
			}
			// 中间可能改变了i；
			ch = s.charAt(i);
			if (ch == ']') {
				if (stack.size() == 1)
					// 如果只剩下一个直接返回了；
					return stack.peek();
				else {
					NestedInteger child = stack.pop();
					// 否则的话把当前的NestedInteger加入到父节点中
					stack.peek().add(child);
				}
			}
			i++;
		}
		return null;
	}
}
