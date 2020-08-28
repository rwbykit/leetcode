package leetcode;

/**
 * 
 * <p>给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。</p>
 * <p>你可以假设除了数字 0 之外，这两个数字都不会以零开头。</p>
 * 
 * <p><strong>
 * 示例：</br>
 * </br>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)</br>
 * 输出：7 -> 0 -> 8</br>
 * 原因：342 + 465 = 807</br></br>
 * </strong></p>
 * 
 * @author Cytus_
 * @since 2018年9月21日 下午4:02:08
 * @version 1.0
 */
public class _0002AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode start2 = new ListNode(3);
    	ListNode s21 = new ListNode(5);
    	ListNode s22 = new ListNode(6);
    	s21.next = s22;
    	start2.next = s21;
    	
    	ListNode start3 = new ListNode(0);
    	ListNode s31 = new ListNode(8);
    	ListNode s32 = new ListNode(9);
    	s31.next = s32;
    	start3.next = s31;
    	
    	ListNode r = addTwoNumbers(start2, start3);
    	System.out.println(ListNode.reverseReadToNumber(r));
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        java.math.BigDecimal bg1 = readListNode(l1);
    	java.math.BigDecimal bg2 = readListNode(l2);
    	java.math.BigDecimal sum = bg1.add(bg2);
        String str = sum.toPlainString();
        ListNode start = new ListNode(Integer.valueOf(String.valueOf(str.charAt(str.length() - 1))));
        ListNode temp = start;
        for (int i = str.length() - 2; i >= 0; i--) {
        	char c = str.charAt(i);
        	ListNode ln = new ListNode(Integer.valueOf(String.valueOf(c)));
        	temp.next = ln;
        	temp = ln;
        }
        return start;
    }
    
    private static java.math.BigDecimal readListNode(ListNode ln) {
    	StringBuffer sb1 = new StringBuffer();
        ListNode ln1 = ln;
        while (ln1 != null) {
        	sb1.append(ln1.val);
        	ln1 = ln1.next;
        }
        return new java.math.BigDecimal(sb1.reverse().toString());
    }

}
