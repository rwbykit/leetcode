package leetcode;

/**
 * 
 * <H3>基本计算器</H3>
 * 
 * <p>实现一个基本的计算器来计算一个简单的字符串表达式的值。</p>
 * <p>字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。</p>
 * 
 * <p>
 * <strong>示例 1:</strong></br>
 * 输入: "1 + 1"</br>
 * 输出: 2</br>
 * </br>
 * <strong>示例 2:</strong></br>
 * </br>
 * 输入: " 2-1 + 2 "</br>
 * 输出: 3</br>
 * </br>
 * <strong>示例 3:</strong></br>
 * </br>
 * 输入: "(1+(4+5+2)-3)+(6+8)"</br>
 * 输出: 23</br>
 * </p>
 * 
 * <p>
 * <strong>说明：</strong></br>
 * <li>你可以假设所给定的表达式都是有效的。</li>
 * <li>请不要使用内置的库函数 eval。</li></p>
 * 
 * @author Cytus_
 * @since 2018年9月25日 上午10:41:25
 * @version 1.0
 */
public class _0224BasicCalculator {
	
	public static void main(String[] args) {
		System.out.println(calculate("2- -22"));
		System.out.println((1+(4+5+2)-3)+(6+8));
		System.out.println(2- -22);
	}
	
	public static int calculate(String s) {
		if (s.length() == 0) {
            return 0;
        }
        s = "(" + s + ")";
        int[] pos = {0};
        return eval(s, pos);
    }
 
    private static int eval(String s, int[] pos) {
        int val = 0, i = pos[0], sign = 1, num = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            switch(c) {
                case '+': val = val + sign * num; num = 0; sign = 1; i++; break;
                case '-': val = val + sign * num; num = 0; sign = -1; i++; break;
                case '(': pos[0] = i + 1; val = val + sign * eval(s, pos); i = pos[0]; break;
                case ')': pos[0] = i + 1; return val + sign * num; 
                case ' ': i++; continue;
                default : num = num * 10 + c - '0'; i++;
            }
        }
        return val;
    }

	

}
