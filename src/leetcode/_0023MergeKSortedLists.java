package leetcode;

import java.util.Objects;

/**
 * 
 * <p>合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。</p>
 * 
 * <p><strong>
 * 输入:</br>
 * [</br>
 *  1->4->5,</br>
 *  1->3->4,</br>
 *  2->6</br>
 * ]</br>
 * 输出: 1->1->2->3->4->4->5->6
 * </strong></p>
 * 
 * @author Cytus_
 * @since 2018年9月21日 下午4:02:08
 * @version 1.0
 */
public class _0023MergeKSortedLists {
	
	public static ListNode mergeKLists(ListNode[] lists) {
        ListNode[] lnList = new ListNode[lists.length];
    	System.arraycopy(lists, 0, lnList, 0, lists.length);
    	ListNode rln = null;
    	ListNode result = rln;
    	while (!isEnd(lnList)) {
    		int minLocation = compareMin(lnList);
    		if (rln == null) {
    			rln = new ListNode(lnList[minLocation].val);
    			result = rln;
    		} else {
    			ListNode next = new ListNode(lnList[minLocation].val);
    			result.next = next;
    			result = next;
    		}
    		if (lists[minLocation] != null)
    			lnList[minLocation] = lnList[minLocation].next;
    	}
    	
    	return rln;
    }
    
    private static boolean isEnd(ListNode[] lnList) {
    	return java.util.Arrays.stream(lnList).allMatch(Objects::isNull);
    }
    
    private static int compareMin(ListNode[] ln) {
    	int min = Integer.MAX_VALUE;
    	int location = -1;
    	for (int i = 0; i < ln.length; i++) {
    		if (java.util.Objects.nonNull(ln[i]) && ln[i].val < min) {
    			min = ln[i].val;
    			location = i;
    		}
    	}
    	return location;
    }

}
