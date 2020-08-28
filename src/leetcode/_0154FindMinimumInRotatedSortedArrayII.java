package leetcode;

import java.util.Arrays;

/**
 * 
 * <p>假设按照升序排序的数组在预先未知的某个点上进行了旋转。</p>
 * <p>( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。</p>
 * <p>请找出其中最小的元素。</p>
 * <p>你可以假设数组中不存在重复元素。</p>
 * 
 * <p><strong>示例 1:</strong></br>
 * </br>
 * 输入: [1,3,5]</br>
 * 输出: 1</br>
 * </br>
 * <strong>示例 2:</strong></br>
 * </br>
 * 输入: [2,2,2,0,1]</br>
 * 输出: 0</p>
 * 
 * <p><strong>说明：</strong></br>
 * <li>这道题是 寻找旋转排序数组中的最小值 的延伸题目。</li>
 * <li>允许重复会影响算法的时间复杂度吗？会如何影响，为什么？</li>
 * </p>
 * 
 * @author Cytus_
 * @since 2018年9月26日 上午10:39:21
 * @version 1.0
 */
public class _0154FindMinimumInRotatedSortedArrayII {
	
	public static int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

}
