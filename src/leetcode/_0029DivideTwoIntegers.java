package leetcode;

import java.util.regex.Pattern;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3

示例 2:

输入: dividend = 7, divisor = -3
输出: -2

说明:

    被除数和除数均为 32 位有符号整数。
    除数不为 0。
    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/divide-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author Cytus_
 * @since 2019年9月11日 上午10:12:30
 * @version 1.0
 */
public class _0029DivideTwoIntegers {

	public static void main(String[] args) {
		/*long d = divide(-2147483648,
				-1017100424


);
		System.out.println(d);*/
		
		
		System.out.println(Pattern.compile("^[\\+\\-]?(\\d+\\.\\d+|\\.\\d+|\\d+\\.|\\d+)(e[\\+\\-]?\\d+)?$").matcher("1 ").find());
	}
	
    public static int divide(int dividend, int divisor) {
    	if (dividend == Integer.MIN_VALUE) { 
    		if (divisor == -1) {
    			return Integer.MAX_VALUE;
    		} else if (divisor == 1) {
    			return dividend;
    		}
    		//return divisor == -1 ? Integer.MAX_VALUE : dividend;
    	}
    	boolean sign = (dividend > 0) ^ (divisor > 0);
    	StringBuilder builderDividend = new StringBuilder(String.valueOf(Math.abs(dividend)).replace("-", ""));
    	StringBuilder builder = new StringBuilder(builderDividend.length());
    	int absDivisor = Math.abs(divisor);
    	String strDivisor = String.valueOf(absDivisor);
    	int lastValue = -1;
    	while (true) {
    		
    		int idx = getIndex(builderDividend, absDivisor);
    		if (idx < 1) {
    			break;
    		}
    		if (lastValue == 0 && idx != strDivisor.length()) {
    			builder.append(0);
    		}
    		
    		String value = builderDividend.substring(0, idx);
    		int intValue = Integer.valueOf(value);
    		int count = 0;
    		while (intValue >= absDivisor) {
    			count++;
    			intValue -= absDivisor;
    		}
    		builderDividend.replace(0, idx, intValue > 0 ? String.valueOf(intValue) : "");
    		builder.append(count);
    		lastValue = intValue;
    	}
    	
        int result = builder.length() > 0 ? Integer.valueOf(builder.toString()) : 0;
        return sign ? -result : result;
    }
    
    
    public static int getIndex(StringBuilder sb, int divisor) {
    	
    	String strDivisor = String.valueOf(divisor);
    	if (sb.length() < strDivisor.length()) {
    		return -1;
    	} else if (sb.length() == strDivisor.length()) {
    		
    		int tint = Integer.valueOf(sb.toString());
    		if (tint < divisor) {
    			return -1;
    		}
    		return strDivisor.length();
    	} else {
    		int tint = Integer.valueOf(sb.substring(0, strDivisor.length()));
    		if (tint < divisor) {
    			return strDivisor.length() + 1;
    		}
    		return strDivisor.length();
    	}
    	
    }
	
}
