package leetcode;

/**
 * 
 * <p>给定一个正整数，返回它在 Excel 表中相对应的列名称。</br>
 * </br>
 * 例如，</br>
 * </br>
 *  1 -> A</br>
 *  2 -> B</br>
 *  3 -> C</br>
 *  ...</br>
 *  26 -> Z</br>
 *  27 -> AA</br>
 *  28 -> AB </br>
 *  ...</p>
 * 
 * <p><strong>示例 1:</strong></br>
 * </br>
 * 输入: 1</br>
 * 输出: "A"</br>
 * </br>
 * <strong>示例 2:</strong></br>
 * </br>
 * 输入: 28</br>
 * 输出: "AB"</br>
 * </br>
 * <strong>示例 3:</strong></br>
 * </br>
 * 输入: 701</br>
 * 输出: "ZY"</p>
 * 
 * @author Cytus_
 * @since 2018年9月26日 下午1:56:01
 * @version 1.0
 */
public class _0168ExcelSheetColumnTitle {

			
	public static void main(String[] args) {
		System.out.println(0%26);
		System.out.println(convertToTitle(704));
	}
	
	public static String convertToTitle(int n) {
		
		String ret = "";
        while(n > 0) {
            ret = (char)((n - 1) % 26 + 'A') + ret;
            n = (n - 1) / 26;
        }
        return ret;
        
    }
	
	
}
