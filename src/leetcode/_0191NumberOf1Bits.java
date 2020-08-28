package leetcode;


/**
 * 
 * <p>编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。</p>
 * 
 * <p><strong>示例 :</strong></br>
 * </br>
 * 输入: 11</br>
 * 输出: 3</br>
 * 解释: 整数 11 的二进制表示为 00000000000000000000000000001011</br>
 * </br>
 * <strong>示例 2:</strong></br>
 * </br>
 * 输入: 128</br>
 * 输出: 1</br>
 * 解释: 整数 128 的二进制表示为 00000000000000000000000010000000</br>
 * </p>
 * 
 * @author Cytus_
 * @since 2018年9月25日 下午5:49:51
 * @version 1.0
 */
public class _0191NumberOf1Bits {
	

	public static int hammingWeight(int n) {
		int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count ++;
        }
		return count;
    }
	
}
