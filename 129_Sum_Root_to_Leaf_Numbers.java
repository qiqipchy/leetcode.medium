import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<Integer> list = new ArrayList<Integer>();
	int sum;

	public int sumNumbers(TreeNode root) {
		dfs(root);
		return sum;
	}

	private void dfs(TreeNode root) {
		// TODO Auto-generated method stub
		if (root != null) {
			list.add(root.val);
		}
		if (root.left == null && root.right == null) {
			// System.out.println(list);
			countSum();
			return;
		}
		int length = list.size();
		if (root.left != null)
			dfs(root.left);
		while (list.size() > length)
			list.remove(list.size() - 1);
		if (root.right != null)
			dfs(root.right);
	}

	private void countSum() {
		// TODO Auto-generated method stub
		int temp = 0;
		for (int i = 0; i < list.size(); i++)
			temp = temp * 10 + list.get(i);
		sum += temp;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = null;
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		root = new TreeThing().buildTree(root, nums);

		System.out.println(solution.sumNumbers(root));

	}
}
