package leetcode;

/**
 * 
 * <p>比较两个版本号 version1 和 version2。</br>
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。</p>
 * 
 * <p>你可以假设版本字符串非空，并且只包含数字和 . 字符。</p>
 * 
 * <p>. 字符不代表小数点，而是用于分隔数字序列。	</p>
 * 
 * <p>例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。</p>
 * 
 * <p><strong>示例 1:</strong></br>
 * </br>
 * 输入: version1 = "0.1", version2 = "1.1"</br>
 * 输出: -1</br>
 * </br>
 * <strong>示例 2:</strong></br>
 * </br>
 * 输入: version1 = "1.0.1", version2 = "1"</br>
 * 输出: 1</br>
 * </br>
 * <strong>示例 3:</strong></br>
 * </br>
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"</br>
 * 输出: -1</p>
 * 
 * @author Cytus_
 * @since 2018年9月26日 下午1:58:51
 * @version 1.0
 */
public class _0165CompareVersionNumbers {

	public static void main(String[] args) {
		//String version1 = "7.5.2.4", version2 = "7.5.3";
		//String version1 = "1.0.1", version2 = "1";
		
		String version1 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
		String version2 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
		System.out.println(compareVersion(version1, version2));
	}
	
	public static int compareVersion(String version1, String version2) {
		
		String[] vers1 = version1.split("\\.");
		String[] vers2 = version2.split("\\.");
		int i = 0, j = 0;
		for (; i < vers1.length && j < vers2.length; i++, j++) {
			if (Integer.valueOf(vers1[i]) > Integer.valueOf(vers2[j])) return 1;
			else if (Integer.valueOf(vers1[i]) < Integer.valueOf(vers2[j])) return -1;
		}
		
		if (i == vers1.length && j != vers2.length) {
			if (!isZero(vers2, j))
				return -1;
		}
		else if (i != vers1.length && j == vers2.length) {
			if (!isZero(vers1, j))
				return -1;
		}
		
		return 0;
        
    }
	
	private static boolean isZero(String[] strs, int start) {
		for (int i = start; i < strs.length; i++) {
			if (0 != Integer.valueOf(strs[i])) return false;
		}
		return true;
	}
	
}
