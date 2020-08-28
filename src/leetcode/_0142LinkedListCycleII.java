package leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。

示例 2：

输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。

示例 3：

输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。
 * 
 * 
 * @author Cytus_
 * @since 2019年9月18日 下午2:23:22
 * @version 1.0
 */
public class _0142LinkedListCycleII {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode _2Node = new ListNode(2);
		ListNode _3Node = new ListNode(0);
		ListNode _4Node = new ListNode(-4);
		head.next = _2Node;
		_2Node.next = _3Node;
		_3Node.next = _4Node;
		_4Node.next = _2Node;
		System.out.println(detectCycle(head));
	}

	public static ListNode detectCycle(ListNode head) {
		
		if (Objects.isNull(head)) return null;
		
		Set<ListNode> set = new HashSet<>();
		ListNode start = head;
		while (start != null) {
			if (set.contains(start)) {
				return start;
			} else {
				set.add(start);
				start = start.next;
			}
			
		}
		return null;
		
		/*
		ListNode slow = head;
		
		ListNode fast = head.next;
		while (slow != fast) {
			
			if (fast == null || fast.next == null) return null;
			slow = slow.next;
			fast = fast.next.next;
			
		}
		return slow;*/
		
        
    }
	
	
}
