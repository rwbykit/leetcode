package leetcode;


public class _0420StrongPasswordChecker {

	public static void main(String[] args) {
		_0420StrongPasswordChecker c = new _0420StrongPasswordChecker();
		System.out.println(c.strongPasswordChecker("aBBB"));
	}
	
	public int strongPasswordChecker(String s) {
        
		int nCount = 0, lCount = 0, uCount = 0;
		int errorCount = 0;
		int lastChar = -1;
		int lastCharNum = 0;
		int updateNum = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ('0' <= c && c <= '9') {
				nCount = 1;
				
				if (lastChar == c) {
					lastCharNum++;
				} else {
					lastChar = c;
					lastCharNum = 1;
				}
				
				if (lastCharNum == 3) {
					lastCharNum --;
					updateNum++;
				}
				
			} else if ('a' <= c && c <= 'z') {
				lCount = 1;
				if (lastChar == c) {
					lastCharNum++;
				} else {
					lastChar = c;
					lastCharNum = 1;
				}
				if (lastCharNum == 3) {
					lastCharNum --;
					updateNum++;
				}
			} else if ('A' <= c && c <= 'Z') {
				uCount = 1;
				if (lastChar == c) {
					lastCharNum++;
				} else {
					lastChar = c;
					lastCharNum = 1;
				}
				
				if (lastCharNum == 3) {
					lastCharNum --;
					updateNum++;
				}
			} else {
				errorCount++;
			}
		}
		
		int result = 3 - nCount - uCount - lCount + updateNum + errorCount;
		
		if (s.length() < 6) {
			int diff = 6 - s.length();
			//result = result > 0 ?
		}
		
		if (s.length() > 20) {
			int diff = 20 - s.length();
			result = result > diff ? result : diff;
		}
		
		return result;
		
    }
	
	
}
