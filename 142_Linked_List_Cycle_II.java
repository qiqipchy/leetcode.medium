import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<ListNode> list = new ArrayList<ListNode>();

	public ListNode detectCycle(ListNode head) {
		ListNode res = null;
		if (head == null)
			return null;
		while (head != null) {
			if (list.contains(head))
				return head;
			list.add(head);
			head = head.next;
		}
		return null;
	}
}
