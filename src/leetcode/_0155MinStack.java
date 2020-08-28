package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 
 * <p>设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 *  <li>push(x) -- 将元素 x 推入栈中。</li>
 *  <li>pop() -- 删除栈顶的元素。</li>
 *  <li>top() -- 获取栈顶元素。</li>
 *  <li>getMin() -- 检索栈中的最小元素。</li></p>
 * 
 * <p><strong>示例:</strong></br>
 * </br>
 * MinStack minStack = new MinStack();</br>
 * minStack.push(-2);</br>
 * minStack.push(0);</br>
 * minStack.push(-3);</br>
 * minStack.getMin();   --> 返回 -3.</br>
 * minStack.pop();</br>
 * minStack.top();      --> 返回 0.</br>
 * minStack.getMin();   --> 返回 -2.</p>
 * 
 * @author Cytus_
 * @since 2018年9月26日 下午2:31:27
 * @version 1.0
 */
public class _0155MinStack {
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-3);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.top());
		System.out.println(stack.getMin());
	}
	
	
	static class MinStack {

		private Stack<Integer> stack;
		
	    /** initialize your data structure here. */
	    public MinStack() {
	        this.stack = new Stack<>();
	    }
	    
	    public void push(int x) {
	        stack.push(x);
	    }
	    
	    public void pop() {
	        stack.pop();
	    }
	    
	    public int top() {
	    	return stack.lastElement();
	    }
	    
	    public int getMin() {
	    	Integer[] vals = stack.toArray(new Integer[stack.size()]);
	    	Arrays.sort(vals, new Comparator<Integer>() {
	
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
			});
	    	return vals[0];
	    }
	}

}
