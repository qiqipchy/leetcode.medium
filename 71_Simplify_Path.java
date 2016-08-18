import java.util.Stack;

public class Solution {
	// .代表的是当前路径，..代表的是上一路径，使用栈结构；
	public String simplifyPath(String path) {
		String[] paths = path.split("/");
		Stack<String> stack = new Stack<String>();
		// stack.push("/");
		for (int i = 0; i < paths.length; i++) {
			if (paths[i].length() == 0)
				continue;
			if (paths[i].equals("..")) {
				// 如果是到了根目录，stack就不弹出了，一直是根目录；
				if (!stack.isEmpty())
					stack.pop();
			} else if (!paths[i].equals("."))
				stack.push(paths[i]);

		}
		String res = "";
		if (stack.isEmpty())
			return "/";
		while (!stack.isEmpty())
			res = "/" + stack.pop() + res;
		return res;
	}

	public static void main(String[] args) {
		String path = "/../a/b/././../../..";
		System.out.println(new Solution().simplifyPath(path));
	}
}
