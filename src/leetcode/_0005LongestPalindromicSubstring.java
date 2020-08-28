package leetcode;

public class _0005LongestPalindromicSubstring {

	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
	}
	
	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return "";
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			
			StringBuilder sb = new StringBuilder(Character.toString(s.charAt(i)));
			for (int j = i + 1; j < s.length(); j++) {
				String c = Character.toString(s.charAt(j));
				sb.append(c);
				if (sb.toString().equals(sb.reverse().toString())) {
					break;
				}
			}
			str = str.length() > sb.length() - 1 ? str : sb.toString().substring(0, sb.length() - 1);
			
		}
		
		
        return str;
    }
	
}
