package leetcode;

/**
 * 
 * <p>给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。</p>
 * <p>k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 
 * <p><strong>示例 :</br>
 * </br>
 * 给定这个链表：1->2->3->4->5</br>
 * </br>
 * 当 k = 2 时，应当返回: 2->1->4->3->5</br>
 * </br>
 * 当 k = 3 时，应当返回: 3->2->1->4->5</br>
 * </strong></p>
 * <p><strong>说明 :</strong>
 * 你的算法只能使用常数的额外空间。</br>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。</br></p>
 * 
 * @author Cytus_
 * @since 2018年9月21日 下午4:14:35
 * @version 1.0
 */
public class _0025ReverseNodesInKGroup {
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
    	
    	int listNodeSize = 0;
    	ListNode tempNode = head;
    	while (tempNode != null) {
    		listNodeSize ++;
    		tempNode = tempNode.next;
    	}
    	
    	if (k > listNodeSize) return head;
    	ListNode[] nodes = reverseKGroup1(head, k);
    	tempNode = nodes[0];
    	ListNode endNode = nodes[1];
    	for (int i = 1; i < listNodeSize / k; i++) {
    		ListNode[] tNode = reverseKGroup1(nodes[1].next, k);
    		endNode.next = tNode[0];
    		nodes = tNode;
    		endNode = nodes[1];
    	}
    	return tempNode;
    }
    
    private static ListNode[] reverseKGroup1(ListNode head, int k) {
    	if (k < 2) return new ListNode[] {head, null};
    	ListNode reverseEndNode = new ListNode(head.val);
    	reverseEndNode.next = head.next;
    	ListNode resultNode = reverseEndNode;
        for (int i = 1; i < k; i++) {
        	ListNode next = reverseEndNode.next;
        	if (next == null) break;
        	ListNode tempNode = new ListNode(next.val);
        	tempNode.next = resultNode;
        	resultNode = tempNode;
        	reverseEndNode.next = next.next;
        }
        return new ListNode[] {resultNode, reverseEndNode};
    }

}
