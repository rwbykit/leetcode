package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _0878NthMagicalNumber {
	
	public static void main(String[] args) {
		System.out.println(nthMagicalNumber(1000000000,
				40000,
				40000));
	}
	
	public static int nthMagicalNumber(int N, int A, int B) {
		int MAX_LIST_SIZE = 2000;
		List<Integer> list = new ArrayList<>(MAX_LIST_SIZE + 1);
		int location = N;
		for (int i = 1; i <= N; i++) {
			if (list.size() > MAX_LIST_SIZE) {
				list.clear();
				location = location - MAX_LIST_SIZE;
			}
			int a = A * i;
			if (!list.stream().anyMatch(s -> s == a)) {
				list.add(a);
			}
			int b = B * i;
			if (!list.stream().anyMatch(s -> s == b)) {
				list.add(b);
			}
			if (list.size() > N * 2) break;
		}
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		System.out.println(list);
		return list.get(location - 1);
        
    }
}