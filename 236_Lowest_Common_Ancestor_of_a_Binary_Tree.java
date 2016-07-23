import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	boolean flag = false;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return null;
		List<TreeNode> p1 = new ArrayList<TreeNode>();
		List<TreeNode> p2 = new ArrayList<TreeNode>();
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		dfs(p1, root, p);
		// 最关键的一步在这里，忘记了设置flag是false；
		flag = false;
		dfs(p2, root, q);
		for (int i = p1.size() - 1; i >= 0; i--) {
			// System.out.println(p1.get(i).val + "------------");
			for (int j = p2.size() - 1; j >= 0; j--) {
				// System.out.println(p2.get(j).val + "+++++++++++");
				if (p1.get(i).equals(p2.get(j)))
					return p1.get(i);
			}
		}
		return null;
	}

	private void dfs(List<TreeNode> p1, TreeNode root, TreeNode p) {
		// TODO Auto-generated method stub
		// System.out.println(root.val + "  ?????????????????/ " +
		// p.val+" "+p1.toString());
		p1.add(root);
		if (root.equals(p)) {
			flag = true;
			return;
		}
		int length = p1.size();
		if (root.left != null)
			dfs(p1, root.left, p);
		if (flag)
			return;
		while (p1.size() != length)
			p1.remove(p1.size() - 1);
		if (root.right != null)
			dfs(p1, root.right, p);
	}
}
