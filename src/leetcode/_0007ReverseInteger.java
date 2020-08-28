package leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321

 示例 2:

输入: -123
输出: -321

示例 3:

输入: 120
输出: 21

注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 * @author Cytus_
 * @since 2019年9月18日 下午5:53:08
 * @version 1.0
 */
public class _0007ReverseInteger {
	
	public static void main(String[] args) {
		
		System.out.println(reverse(-12312));
		
	}
	
	public static int reverse(int x) {
		boolean sign = x >= 0 ;
		String s = String.valueOf(x);
		String rs = new StringBuffer(s.replace("-", "")).reverse().toString();
		if (sign) {
			return Double.valueOf(rs).compareTo(Double.valueOf(Integer.MAX_VALUE)) >= 0 ? 0 : Integer.valueOf(rs);
		} else {
			return Double.valueOf("-"+ rs).compareTo(Double.valueOf(Integer.MIN_VALUE)) < 0 ? 0 : Integer.valueOf("-"+ rs); 
		}
		
    }

}
