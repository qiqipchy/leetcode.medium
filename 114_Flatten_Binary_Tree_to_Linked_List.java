import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<Integer> list = new ArrayList<Integer>();

	public void flatten(TreeNode root) {
		dfs(root);
		System.out.println(list);
		int i = 1;
		while (i < list.size()) {
			root.left = null;
			root.right = new TreeNode(list.get(i));
			root = root.right;
			i++;
		}
	}

	private void dfs(TreeNode root) {
		// TODO Auto-generated method stub
		if (root != null) {
			list.add(root.val);
		} else
			return;
		if (root.left != null)
			dfs(root.left);
		if (root.right != null)
			dfs(root.right);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = null;
		int[] nums = { 1, 2, 3 };
		root = new TreeThing().buildTree(root, nums);

		// 在函数中使用root=returnRoot是不行的；
		// 因为传递的是地址，修改的是地址中的内容，而不是地址
		// 地址临时改变了，但是root在参与函数的时候，使用的还是原来的地址中的内容
		solution.flatten(root);
		new TreeThing().print(root);

	}
}
