package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）</p>
 * 
 * <p>现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。</br>
 * 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。</p>
 * 
 * <p><strong>示例 1：</strong></br>
 * </br>
 * 输入：D = ["1","3","5","7"], N = 100</br>
 * 输出：20</br>
 * 解释：</br>
 * 可写出的 20 个数字是：</br>
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.</br>
 * </br>
 * <strong>示例 2：</strong></br>
 * </br>
 * 输入：D = ["1","4","9"], N = 1000000000</br>
 * 输出：29523</br>
 * 解释：</br>
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，</br>
 * 81 个四位数字，243 个五位数字，729 个六位数字，</br>
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。</br>
 * 总共，可以使用D中的数字写出 29523 个整数。</p>
 * 
 *  
 * 
 * <p><strong>提示：</strong>
 * <li>D 是按排序顺序的数字 '1'-'9' 的子集。</li>
 * <li>1 <= N <= 10^9</li></p>
 * 
 * @author Cytus_
 * @since 2018年9月29日 下午5:30:00
 * @version 1.0
 */
public class _0902NumbersAtMostNGivenDigitSet {
	
	public static void main(String[] args) {
		String[] D = new String[] {"3","4","5","6"	};
		System.out.println(atMostNGivenDigitSet(D, 6664));
	}
	
	public static int atMostNGivenDigitSet(String[] D, int N) {
		
		String nStr = String.valueOf(N);
		int nLength = nStr.length();
		
		int count = 0;
		for (int i = 1; i < nLength; i++) {
			count = (int) (count + Math.pow(D.length, i));
		}
		
		List<Integer> list = new ArrayList<>(nLength);
		for (int j = 0; j < nLength; j++) {
			int num = 0;
			for (int i = 0; i < D.length; i++) {
				if (Integer.valueOf(D[i]) > Integer.valueOf(String.valueOf(nStr.charAt(j)))) break;
				++num;
			}
			list.add(num);
		}
		int num = 1;
		for (Integer i : list) {
			num = num * i;
		}
		
		return count + num;
	}

}
