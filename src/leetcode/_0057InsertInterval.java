package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1:

输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]

示例 2:

输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出: [[1,2],[3,10],[12,16]]
解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 
 * @author Cytus_
 * @since 2019年9月18日 上午10:39:07
 * @version 1.0
 */
public class _0057InsertInterval {
	
	public static void main(String[] args) {
		
		
		//int[][] r = insert(new int[][] {{1,3},{6,9}}, new int[] {2, 5});
		int[][] r = insert(new int[][] {{-10,-8}, {-7,0} ,{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {-9, 8});
		
		System.out.println(r);
	} 

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		
		List<int[]> list = new LinkedList<>(Arrays.asList(intervals));
		list.add(newInterval);
		list.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));
		for (int i = 0; i < list.size() - 1; i++) {
			int[] t1 = list.get(i);
			int[] t2 = list.get(i + 1);
			if (t1[1] >= t2[0]) {
				
				t2[0] = Math.min(t1[0], t2[0]);
				t2[1] = Math.max(t1[1], t2[1]);
				list.set(i, null);
				
			}
		}
		
		list = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
		int[][] result = new int[list.size()][];
		int k = 0;
		for (int[] ia : list) {
			result[k] = ia;
			k++;
		}
		return result;
		
    }
	
}
