package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * <p>如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。</p>
 * <p>现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。</p>
 * 
 * <p><strong>示例：</strong></br>
 * </br>
 * 输入：L = "4", R = "1000"</br>
 * 输出：4</br>
 * <strong>解释：</strong></br>
 * 4，9，121，以及 484 是超级回文数。</br>
 * 注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。</p>
 * 
 * <p><strong>提示：</strong>
 * <li>1 <= len(L) <= 18 </li>
 * <li>1 <= len(R) <= 18</li>
 * <li>L 和 R 是表示 [1, 10^18) 范围的整数的字符串。</li>
 * <li>int(L) <= int(R)</li></p>
 * 
 * @author Cytus_
 * @since 2018年9月28日 上午9:54:41
 * @version 1.0
 */
public class _0906SuperPalindromes {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(superpalindromesInRange("1","999999999999999999"));
		//System.out.println(superpalindromesInRange("11695","23815"));
		long sqrtInt = (long) Math.sqrt(Double.valueOf("11695"));
    	//long start1 = (long) Math.sqrt(Double.valueOf("999999999999999999"));
    	System.out.println();
    	System.out.println(sqrtInt);
    	//System.out.println(start1);
		System.out.println(System.currentTimeMillis() - start);
	}
	
	
    public static int superpalindromesInRange(String L, String R) {
    	
    	long sqrtInt = (long) Math.sqrt(Double.valueOf(R));
    	long start = (long) Math.sqrt(Double.valueOf(L));
    	List<Long> list = new LinkedList<Long>();
    	long end = sqrtInt < 10 ? sqrtInt : 10l;
    	if (start < 10) {
    		for (long i = start; i < end; i++) {
    			if (i <= sqrtInt)
    				list.add(i * i);
        	}
    	}
    	
    	long palindrome = findOnePalindromes(start >= 10l ? start : 10l);
    	list.add(palindrome * palindrome);
    	while (true) {
    		palindrome = findNextPalindromes(palindrome);
    		if (palindrome > sqrtInt) break;
    		list.add(palindrome * palindrome);
    	}
        return (int) list.parallelStream().filter(s -> isPalindromes(s)).count();
    }
    
    public static long findOnePalindromes(long start) {
    	if (isPalindromes(start)) return start;
    	StringBuffer sb = new StringBuffer();
    	sb.append(dealStart(start));
    	int middle = sb.length() / 2;
    	for (int i = 0; i < middle; i++) {
    		sb.setCharAt(sb.length() - i - 1, sb.charAt(i));
    	}
    	return Long.valueOf(sb.toString());
    }
    
    public static long dealStart(long start) {
    	if (start < 100) return start;
    	String str = String.valueOf(start);
    	int middle = str.length() / 2;
    	String L = str.substring(0, middle);
    	String R = str.substring(isOddNumber(middle) ? middle + 1 : middle);
    	StringBuffer sb = new StringBuffer(R);
    	sb.reverse();
    	R = sb.toString();
    	if (Long.valueOf(L) < Long.valueOf(R)) {
    		return (long) (start + Math.pow(10, middle));
    	}
    	return start;
    }
    
    public static boolean isPalindromes(long val) {
    	String valStr = String.valueOf(val);
    	int middle = valStr.length() / 2;
    	for (int i = 0; i < middle; i++) {
    		if (valStr.charAt(i) != valStr.charAt(valStr.length() - i - 1)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static long findNextPalindromes(long val) {
    	if (val < 10l) return ++val;
    	String str = String.valueOf(val);
    	int middle = str.length() / 2;
    	if (str.charAt(middle) == '9') {
	    	long temp = (long) Math.pow(10, middle);
	    	val = ((val + temp) / temp) * temp;
	    	return findOnePalindromes(val);
    	} else {
    		if (isOddNumber(str.length())) {
	    		val += (long) Math.pow(10, middle);
	    	} else {
	    		val += (long) (Math.pow(10, middle - 1) * 11l);
	    	}
    	}
    	return val;
    }
    
    static boolean isOddNumber(int i) {
    	return (i & 1) == 1;
    }
    
    /*
    代码手中走~佛祖心中留！求永无BUG！
                       _ooOoo_
                      o8888888o
                      88" . "88
                      (| -_- |)
                      O\  =  /O
                   ____/`---'\____
                 .'  \\|     |//  `.
                /  \\|||  :  |||//  \
               /  _||||| -:- |||||-  \
               |   | \\\  -  /// |   |
               | \_|  ''\---/''  |   |
                \  .-\__  `-`  ___/-. /
              ___`. .'  /--.--\  `. . __
           ."" '<  `.___\_<|>_/___.'  >'"".
          | | :  `- \`.;`\ _ /`;.`/ - ` : | |
          \  \ `-.   \_ __\ /__ _/   .-` /  /
     ======`-.____`-.___\_____/___.-`____.-'======
     */

}
