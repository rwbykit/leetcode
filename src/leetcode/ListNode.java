package leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ListNode {

	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	
	static BigDecimal reverseReadToNumber(ListNode ln) {
    	if (ln == null) return null;
    	StringBuffer sb1 = new StringBuffer();
        ListNode ln1 = ln;
        while (ln1 != null) {
        	sb1.append(ln1.val);
        	ln1 = ln1.next;
        }
        return new BigDecimal(sb1.reverse().toString());
    }
    
    static String read(ListNode ln) {
    	if (ln == null) return null;
    	List<String> list = new ArrayList<>();
        ListNode ln1 = ln;
        while (ln1 != null) {
        	list.add(String.valueOf(ln1.val));
        	ln1 = ln1.next;
        }
        return list.toString();
    }

    static ListNode create(String strs, String splitKey) {
		String[] strings = strs.split(splitKey);
		ListNode head = null;
		ListNode nextNode = null;
		for (int i = 0; i < strings.length; i++) {
			if (head == null) {
				head = new ListNode(Integer.parseInt(strings[i]));
				nextNode = head;
				continue;
			}
			ListNode tNode = nextNode;
			nextNode = new ListNode(Integer.parseInt(strings[i]));
			tNode.next = nextNode;
		}
		return head;
	}

}
