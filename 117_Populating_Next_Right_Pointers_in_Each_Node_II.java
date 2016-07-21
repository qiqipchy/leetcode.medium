import java.util.LinkedList;
import java.util.Queue;
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		Queue<Integer> depth = new LinkedList<Integer>();
		depth.add(1);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeLinkNode parent = queue.poll();
			Integer parDep = depth.poll();

			if (parent.left != null) {
				queue.add(parent.left);
				depth.add(parDep + 1);
			}
			if (parent.right != null) {
				queue.add(parent.right);
				depth.add(parDep + 1);

			}
			//还是广度搜索；
			if (!queue.isEmpty()) {
				TreeLinkNode next = queue.peek();
				Integer nextDep = depth.peek();
				if (nextDep != parDep)
					parent.next = null;
				else
					parent.next = next;
			} else
				parent.next = null;
		}

	}
}
