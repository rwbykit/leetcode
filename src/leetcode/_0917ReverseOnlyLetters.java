package leetcode;

/**
 * 
 * <p>给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。</p>
 * 
 * <p><strong>示例 1：</strong></br>
 * </br>
 * 输入："ab-cd"</br>
 * 输出："dc-ba"</br>
 * </br>
 * <strong>示例 2：</strong></br>
 * </br>
 * 输入："a-bC-dEf-ghIj"</br>
 * 输出："j-Ih-gfE-dCba"</br>
 * </br>
 * <strong>示例 3：</strong></br>
 * </br>
 * 输入："Test1ng-Leet=code-Q!"</br>
 * 输出："Qedo1ct-eeLg=ntse-T!"</p>
 * 
 * <p><strong>提示：</strong>
 * 
 * <li>S.length <= 100</li>
 * <li>33 <= S[i].ASCIIcode <= 122 </li>
 * <li>S 中不包含 \ or "</li></p>
 * 
 * @author Cytus_
 * @since 2018年10月8日 下午5:35:27
 * @version 1.0
 */
public class _0917ReverseOnlyLetters {
	
	public String reverseOnlyLetters(String S) {
		
		int startIdx = 0;
		int endIdx = S.length() - 1;
		StringBuffer sb = new StringBuffer(S);
		for (int i = startIdx; i <= Math.ceil(S.length()); i++, endIdx--) {
			if (onlyLetter(S.charAt(i))) {
				if (onlyLetter(S.charAt(endIdx))) {
					sb.setCharAt(i, S.charAt(endIdx));
					//sb.setCharAt(endIdx, sb.charAt(index));
				}
			} 
		}
		return S;
        
    }
	
	private static boolean onlyLetter(char c) {
		int i = (int) c;
		return (i >= 65 && i <= 90) || (i >= 97 && i <= 122);
	}

}
