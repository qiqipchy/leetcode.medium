import java.util.ArrayList;
import java.util.List;

public class Solution {
	int[] path;
	List<List<Integer>> pathList = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return pathList;
		dfs(root, 0, sum);
		return pathList;
	}

	private void dfs(TreeNode root, int local, int sum) {
		// TODO Auto-generated method stub
		if (root.left == null && root.right == null) {
			if (local + root.val == sum) {
				list.add(root.val);
				// 注意这里是新的array，copy list中的值；
				List<Integer> array = new ArrayList<Integer>(list);
				// System.out.println(array);
				pathList.add(array);
				return;
			} else
				return;
		}
		int length = list.size();
		if (root.left != null) {
			list.add(root.val);
			dfs(root.left, local + root.val, sum);
		}
		// System.out.println(list);
		while (list.size() > length)
			list.remove(list.size() - 1);
		if (root.right != null) {
			list.add(root.val);
			dfs(root.right, local + root.val, sum);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = null;
		int[] nums = { 1, 0, 1, 1, 2, 0, -1, 0, 1, -1, 0, -1, 0, 1, 0 };
		root = new TreeThing().buildTree(root, nums);
		System.out.println(solution.pathSum(root, 2));
	}
}
