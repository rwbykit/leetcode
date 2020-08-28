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
 * 输入: [3,4,5,1,2]</br>
 * 输出: 1</br>
 * </br>
 * <strong>示例 2:</strong></br>
 * </br>
 * 输入: [4,5,6,7,0,1,2]</br>
 * 输出: 0</p>
 * 
 * @author Cytus_
 * @since 2018年9月26日 上午10:39:21
 * @version 1.0
 */
public class _0153FindMinimumInRotatedSortedArray {
	
	public static int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

}
