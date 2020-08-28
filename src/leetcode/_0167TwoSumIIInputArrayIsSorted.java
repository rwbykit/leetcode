package leetcode;

import java.util.Arrays;

/**
 * 
 * <p>给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。</p>
 * <p>函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。</p>
 * <p><strong>说明:</strong>
 * <li>返回的下标值（index1 和 index2）不是从零开始的。</li>
 * <li>你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。</li></p>
 * 
 * <p><strong>示例:</strong></br>
 * </br>
 * 输入: numbers = [2, 7, 11, 15], target = 9</br>
 * 输出: [1,2]</br>
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。</br></p>
 * 
 * 
 * @author Cytus_
 * @since 2018年9月26日 上午10:47:27
 * @version 1.0
 */
public class _0167TwoSumIIInputArrayIsSorted {
	
	public static void main(String[] args) {
		int[] numbers = new int[] {0,0,3,4};
		System.out.println(Arrays.toString(twoSum(numbers, 0)));
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int end = numbers.length - 1;
		for (int i = 0; i < end; i++) {
			int otherVal = target - numbers[i];
			if (otherVal < numbers[i]) {
				return null;
			}
			int index = Arrays.binarySearch(numbers, i + 1, numbers.length, otherVal);
			if (index > 0) {
				return new int[] {i + 1, index + 1};
			}
		}
		return null;
        
    }

}
