package leetcode;

import java.util.Arrays;

/**
 * 
 * <p>在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。</p>
 * 
 * <p>
 * <strong>示例 1:</strong></br>
 * </br>
 * 输入: [3,2,1,5,6,4] 和 k = 2</br>
 * 输出: 5</br>
 * </br>
 * <strong>示例 2:</strong></br>
 * </br>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4</br>
 * 输出: 4</br>
 * </p>
 * <strong>说明:</strong></br>
 * </br>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * </p>
 * 
 * 
 * @author Cytus_
 * @since 2018年9月25日 下午5:11:42
 * @version 1.0
 */
public class _0215KthLargestElementInAnArray {
	
	public static void main(String[] args) {
		int[] nums = {3,2,3,1,2,4,5,5,6};
		System.out.println(findKthLargest(nums, 4));
	}
	
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
    }

}
