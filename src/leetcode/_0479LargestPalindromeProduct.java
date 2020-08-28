package leetcode;

public class _0479LargestPalindromeProduct {
	/**
	 * 4   597
	 * 5   677
	 * 6   1218
	 * @param args
	 */
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		System.out.println(largestPalindrome(6));
		System.out.println(System.currentTimeMillis() - s);
//		BigDecimal b = BigDecimal.valueOf(12312.001);
//		System.out.println(b.unscaledValue());
		//System.out.println(Math.sqrt(906609));
		//System.out.println(getMultiplier(906609, 999));
		/*BigDecimal bd = BigDecimal.valueOf(906609);
		for (int i = 999 ; i > 500; i--) {
			System.out.println(bd.divide(BigDecimal.valueOf(i), 2, RoundingMode.HALF_UP).toString());
		}*/
		
		//System.out.println(Long.reverse(12345));
	}
	
	

	public static int largestPalindrome(int n) {
        
		if (n == 1) return 9;
		long maxValue = (long) Math.pow(10, n) - 1;
		long low = maxValue / 10;
		for (long i = maxValue ; i > 0; i--) {
			StringBuilder sb = new StringBuilder(String.valueOf(i));
			String p = sb.toString() + sb.reverse().toString();
			long pv = Long.parseLong(p);
			long mid = (long) Math.sqrt(pv);
			for (long j = mid; j >= low; j--) {
				if (pv % j == 0 && pv / j <= maxValue) {
					return (int) (pv % 1337);
					
				}
			}
		}
		return 0;
    }
	
	
}
