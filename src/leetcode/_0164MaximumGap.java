package leetcode;

import java.util.Arrays;

/**
 * 
 * <p>给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。</p>
 * 
 * <p>如果数组元素个数小于 2，则返回 0。</p>
 * 
 * <p><strong>示例 1:</strong></br>
 * </br>
 * 输入: [3,6,9,1]</br>
 * 输出: 3</br>
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。</br>
 * </br>
 * <strong>示例 2:</strong>
 * </br>
 * 输入: [10]</br>
 * 输出: 0</br>
 * 解释: 数组元素个数小于 2，因此返回 0。</br></p>
 * 
 * <p>说明:
 * <li>你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。</li>
 * <li>请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。</li></p>
 * 
 * 
 * @author Cytus_
 * @since 2018年9月26日 下午5:07:55
 * @version 1.0
 */
public class _0164MaximumGap {
	
	public static void main(String[] args) {
		int[] nums = {3,6,9,1};
		System.out.println(maximumGap(nums));
	}
	
	public static int maximumGap(int[] nums) {
		if (nums.length < 2) return 0;
		Arrays.sort(nums);
		int end = nums.length - 1;
		int min = Integer.MIN_VALUE;
		int temp = Integer.MIN_VALUE;
		for (int i = 0; i < end; i++) {
			temp = nums[i + 1] - nums[i];
			if (temp > min) {
				min = temp;
			}
		}
		return min;
        
    }

}
