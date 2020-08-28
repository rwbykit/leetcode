package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 
 * <p>实现 FreqStack，模拟类似栈的数据结构的操作的一个类。</p>
 * 
 * <p>FreqStack 有两个函数：
 * 
 * <li>push(int x)，将整数 x 推入栈中。</li>
 * <li>pop()，它移除并返回栈中出现最频繁的元素。</br>
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。</li></p>
 * 
 * <p><strong>示例：</strong></br>
 * </br>
 * 输入：</br>
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],</br>
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]</br>
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]</br>
 * 解释：</br>
 * 执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：</br>
 * </br>
 * pop() -> 返回 5，因为 5 是出现频率最高的。</br>
 * 栈变成 [5,7,5,7,4]。</br>
 * </br>
 * pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。</br>
 * 栈变成 [5,7,5,4]。</br>
 * </br>
 * pop() -> 返回 5 。</br>
 * 栈变成 [5,7,4]。</br>
 * </br>
 * pop() -> 返回 4 。</br>
 * 栈变成 [5,7]。</br></p>
 * 
 * <p><strong>提示：</strong></br>
 * 
 * <li>对 FreqStack.push(int x) 的调用中 0 <= x <= 10^9。</li>
 * <li>如果栈的元素数目为零，则保证不会调用  FreqStack.pop()。</li>
 * <li>单个测试样例中，对 FreqStack.push 的总调用次数不会超过 10000。</li>
 * <li>单个测试样例中，对 FreqStack.pop 的总调用次数不会超过 10000。</li>
 * <li>所有测试样例中，对 FreqStack.push 和 FreqStack.pop 的总调用次数不会超过 150000。</li></p>
 * 
 * @author Cytus_
 * @since 2018年9月28日 下午5:16:24
 * @version 1.0
 */
public class _0895MaximumFrequencyStack {
	
	public static void main(String[] args) {
		FreqStack stack = new FreqStack();
		stack.push(5);
		stack.push(7);
		stack.push(5);
		stack.push(7);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	static class FreqStack {
		
		List<Integer> list;
		SortedMap<SortedKey, SortedKey> sortedMap;

	    public FreqStack() {
	        list = new LinkedList<>();
	        sortedMap = new TreeMap<>(new Comparator<SortedKey>() {

				@Override
				public int compare(SortedKey o1, SortedKey o2) {
					return Integer.compare(o2.key, o1.key);
				}
			});
	    }
	    
	    public void push(int x) {
	    	list.add(x);
	    	
	    	SortedKey key = new SortedKey(x, 0);
	    	key = sortedMap.getOrDefault(key, key);
	    	key.freq = key.freq + 1;
	    	//sortedMap.remove(key);
	    	sortedMap.put(key, key);
	    }
	    
		public int pop() {
			List<SortedKey> ls = new ArrayList<>();
	    	SortedKey key = sortedMap.firstKey();
	    	//sortedMap.remove(key);
			while (true) {
				SortedKey tempKey = sortedMap.firstKey();
				if (tempKey.freq != key.freq) break;
				ls.add(tempKey);
				//sortedMap.remove(key);
			}
			
	    	int index = this.list.lastIndexOf(key.key);
	    	for (int i = 1; i < ls.size(); i++) {
	    		SortedKey temp = ls.get(i);
	    		int idx = this.list.lastIndexOf(temp.key);
	    		if (idx > index) {
	    			index = idx;
	    			key = temp;
	    		}
	    	}
	    	
	    	this.list.remove(index);
	    	if (key.freq > 0) {
	    		key.freq = key.freq - 1;
	    		sortedMap.put(key, key);
	    	}
			
	    	return 0;
	    }
	    
	    static class SortedKey implements Comparator<SortedKey>, Comparable<SortedKey> {
	    	Integer key;
	    	int freq;
	    	
	    	public SortedKey() {
	    		super();
	    	}
	    	
	    	public SortedKey(int key, int freq) {
	    		this.key = key;
	    		this.freq = freq;
	    	}
	    	
			@Override
			public int compare(SortedKey o1, SortedKey o2) {
				return Integer.compare(o1.freq, o2.freq);
			}
	    	
			@Override
			public boolean equals(Object o) {
				return key.equals(o);
			}
			
			@Override
			public int hashCode() {
				return key.hashCode();
			}

			@Override
			public int compareTo(SortedKey o) {
				return Integer.compare(key, o.key);
			}
			
			public String toString() {
				return "[key:"+ key + ", freq:"+ freq +"]";
			}
	    }
	    
	}
	
}
