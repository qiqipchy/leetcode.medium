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
	int[] corr;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length == 0 || preorder.length == 0)
			return null;

		// 中序中的各个元素在前序中的位置；修改了寻找节点的方法；
		corr = new int[inorder.length];
		for (int i = 0; i < inorder.length; i++) {
			for (int j = preorder.length - 1; j >= 0; j--) {
				if (inorder[i] == preorder[j]) {
					corr[i] = j;
					break;
				}
			}
		}

		return buildTreeIter(inorder, preorder, 0, inorder.length);
	}

	public TreeNode buildTreeIter(int[] inorder, int[] preorder, int bin,
			int ein) {
		// 节点的位置；
		// System.out.println(bin + " " + ein + " ");
		int index = findNode(bin, ein);
		System.out.println(index);
		TreeNode root = new TreeNode(inorder[index]);
		if (bin + 1 == index) {
			root.left = new TreeNode(inorder[bin]);
		} else if (bin == index)
			root.left = null;
		else
			root.left = buildTreeIter(inorder, preorder, bin, index);

		if (index + 1 + 1 == ein) {
			root.right = new TreeNode(inorder[index + 1]);
		} else if (index + 1 == ein)
			root.right = null;
		else
			root.right = buildTreeIter(inorder, preorder, index + 1, ein);
		return root;

	}

	int findNode(int begin, int end) {
		int min = begin;
		for (int i = begin; i < end; i++)
			//跟后序是一样的，但是是在中序中靠前的位置；
			if (corr[i] < corr[min])
				min = i;
		return min;
	}

	void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val + "--------");
		printInorder(root.left);
		printInorder(root.right);
	}

	public static void main(String[] args) {
		int[] preorder = { 1, 2, 3, 4, 5, 6 };
		int[] inorder = { 3, 2, 4, 1, 6, 5 };
		TreeNode root = new Solution().buildTree(preorder, inorder);
		new Solution().printInorder(root);
	}
}
