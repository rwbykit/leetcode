package leetcode;


/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * @author Cytus_
 * @since 2019年9月18日 下午4:52:37
 * @version 1.0
 */
public class _0003LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		int defLen = 1;
		for (int i = 0; i < s.length(); i++) {
			
			String temp = Character.toString(s.charAt(i));
			for (int j = i + 1; j < s.length(); j++) {
				String c = Character.toString(s.charAt(j));
				if (temp.contains(c)) {
					break;
				}
				temp += c;
			}
			defLen = temp.length() > defLen ? temp.length() : defLen;
			
		}
		
		
        return defLen;
    }
	
	
}
