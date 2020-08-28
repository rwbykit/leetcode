package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。</p>
 * <p>你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。</p>
 * 
 * <p><strong>
 * 示例:</br>
 * 给定 nums = [2, 7, 11, 15], target = 9</br>
 * </br>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9</br>
 * 所以返回 [0, 1]</br>
 * </strong></p>
 * 
 * @author Cytus_
 * @since 2018年9月21日 下午4:02:08
 * @version 1.0
 */
public class _0001SumTwoNumbers {
	
	public static void main(String[] args) {
		int[] nums = {-1,-2,-3,-4,-5, 1};
    	int[] r = twoSum(nums, 0);
    	System.out.println(Arrays.toString(r));
	}

	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapInt = new HashMap<>();
    	for (int i = 0 ;i < nums.length; i++) {
    		int temp = target - nums[i];
    		if (mapInt.containsKey(temp)) {
    			return new int[] {mapInt.get(temp), i};
    		}
    		mapInt.put(nums[i], i);
    	}
        throw new IllegalArgumentException("not exist!");
    }
	
}
