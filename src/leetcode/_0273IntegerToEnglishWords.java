package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 。</p>
 * 
 * <p>
 * <strong>示例 1:</strong></br>
 * </br>
 * 输入: 123</br>
 * 输出: "One Hundred Twenty Three"</br>
 * </br>
 * <strong>示例 2:</strong></br>
 * 
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * 
 * <strong>示例 3:</strong>
 * 
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * <strong>示例 4:</strong>
 * 
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * </p>
 * 
 * @author Cytus_
 * @since 2018年9月25日 下午3:43:10
 * @version 1.0
 */
public class _0273IntegerToEnglishWords {
	
	private final static String[] DIGIT_ENG = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	
	private final static String[] DEC_ENG = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	
	private final static String[] TDEC_ENG = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	private final static String[] ENG_UNIT = {"", "Thousand", "Million", "Billion", "Trillions"};
	
	private final static String HUNDRED = "Hundred";
	
	private final static int FIX_NUM = 1000;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(numberToWords(10000001));
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static String numberToWords(int num) {
		if (num == 0) return "Zero";
		int tempNum = num;
		List<String> list = new ArrayList<>();
		int i = 0;
		while (true) {
			int t = tempNum % FIX_NUM;
			list.add(numToString(t, ENG_UNIT[i]));
			if (t == tempNum) break;
			tempNum = tempNum / FIX_NUM;
			i++;
		}
		StringBuffer sb = new StringBuffer();
		for (int j = list.size() - 1; j >= 0; j--) {
			sb.append(list.get(j));
		}
		return sb.toString().trim();
		//Collections.reverse(list);
        //return list.stream().reduce("", String::concat).trim();
    }
	
	public static String numToString(int num, String unit) {
		StringBuffer sb = new StringBuffer();
		if (num >= 100) sb.append(DIGIT_ENG[num / 100]).append(" ").append(HUNDRED).append(" ");
		int dec = num % 100;
		if (dec >= 20) {
			sb.append(TDEC_ENG[dec / 10]).append(" ");
			if (dec % 10 != 0) sb.append(DIGIT_ENG[dec % 10]).append(" ");
		} else if (dec >= 10 && dec < 20) {
			sb.append(DEC_ENG[dec % 10]).append(" ");
		} else if (dec > 0){
			sb.append(DIGIT_ENG[dec % 10]).append(" ");
		}
		
		if (sb.length() > 0)
			sb.append(unit).append(" ");
		return sb.toString();
	}

}
