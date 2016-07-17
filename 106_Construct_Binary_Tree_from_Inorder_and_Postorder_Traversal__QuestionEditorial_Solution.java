class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	// 从后序中确定节点的位置，前面的就是左节点的，后面的就是右节点的；
	int[] inorder, postorder, corr;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0)
			return null;
		this.inorder = new int[inorder.length];
		this.postorder = new int[inorder.length];
		// 前序中的各个元素在后序中的位置；修改了寻找节点的方法；
		corr = new int[inorder.length];
		for (int i = 0; i < inorder.length; i++) {
			for (int j = postorder.length - 1; j >= 0; j--) {
				if (inorder[i] == postorder[j]) {
					corr[i] = j;
					break;
				}
			}
		}

		System.arraycopy(inorder, 0, this.inorder, 0, inorder.length);
		System.arraycopy(postorder, 0, this.postorder, 0, postorder.length);

		return buildTreeIter(0, inorder.length);
	}

	public TreeNode buildTreeIter(int bin, int ein) {
		// 节点的位置；
		System.out.println(bin + " " + ein + " ");
		int index = findNode(bin, ein);
		TreeNode root = new TreeNode(inorder[index]);
		if (bin + 1 == index) {
			root.left = new TreeNode(inorder[bin]);
		} else if (bin == index)
			root.left = null;
		else
			root.left = buildTreeIter(bin, index);

		if (index + 1 + 1 == ein) {
			root.right = new TreeNode(inorder[index + 1]);
		} else if (index + 1 == ein)
			root.right = null;
		else
			root.right = buildTreeIter(index + 1, ein);
		return root;

	}

	int findNode(int begin, int end) {
		int max = begin;
		for (int i = begin; i < end; i++)
			if (corr[i] > corr[max])
				max = i;
		return max;
	}

	/*
	 * void printInorder(TreeNode root) { if (root == null) return;
	 * printInorder(root.left); System.out.println(root.val + "--------");
	 * printInorder(root.right); }
	 */

	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 3 };
		int[] postorder = { 5, 4, 2, 3, 1 };
		TreeNode root = new Solution().buildTree(inorder, postorder);
		// new Solution().printInorder(root);
	}
}
