/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   public int rob(TreeNode root)
	{
		// 设定一个数组,res[0]表示不抢root,res[1]表示抢了root
		int[] res=robIter(root);
		return Math.max(res[0],res[1]);
	}
	public int[] robIter(TreeNode root)
	{
		int[] res=new int[2];
		if(root==null)
			return res;
		int[] left=robIter(root.left);
		int[] right=robIter(root.right);
		
		res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
		res[1]=root.val+left[0]+right[0];
		
		return res;
	}
}
