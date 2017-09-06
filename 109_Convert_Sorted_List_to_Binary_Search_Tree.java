import java.util.ArrayList;
import java.util.Map;   


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	List<Integer> list = new ArrayList<Integer>();

	public TreeNode sortedListToBST(ListNode head) {
		while (head != null) {

			list.add(head.val);
			head = head.next;
		}

		return convertToBST(0, list.size() - 1);

	}

	private TreeNode convertToBST(int begin, int end) {
		// TODO Auto-generated method stub
		System.out.println(begin + " " + end);
		if (begin > end)
			return null;
		int middle = (begin + end) / 2;
		TreeNode parent = new TreeNode(list.get(middle));
		parent.left = convertToBST(begin, middle - 1);
		parent.right = convertToBST(middle + 1, end);
		return parent;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.list.add(1);
		solution.list.add(2);
		solution.list.add(3);
		solution.list.add(4);
		solution.list.add(5);
		solution.list.add(6);
		solution.list.add(7);
		solution.list.add(8);
		solution.list.add(9);
		TreeNode root = solution.convertToBST(0, solution.list.size() - 1);
		new TreeThing().print(root);
	}
}
