package leetcode;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0

示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 * @author Cytus_
 * @since 2019年9月18日 下午4:43:38
 * @version 1.0
 */
public class _0004MedianOfTwoSortedArrays {
	
	
	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
	}
	

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int[] num = new int[nums1.length + nums2.length];
		System.arraycopy(nums1, 0, num, 0, nums1.length);
		System.arraycopy(nums2, 0, num, nums1.length, nums2.length);
		Arrays.sort(num);
		int mid = num.length / 2;
		if (num.length % 2 == 0) {
			return (num[mid - 1] + num[mid]) / 2d;
		} else {
			return num[mid];
		}
	}
	
	
}
