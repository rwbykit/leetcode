package leetcode;

import java.util.Stack;

/**
 * <p>使用栈实现队列的下列操作：
 * <li>push(x) -- 将一个元素放入队列的尾部。</li>
 * <li>pop() -- 从队列首部移除元素。</li>
 * <li>peek() -- 返回队列首部的元素。</li>
 * <li>empty() -- 返回队列是否为空。</li>
 * </p>
 * 
 * <p>
 * <strong>示例:</strong></br>
 * MyQueue queue = new MyQueue();</br>
 * queue.push(1);</br>
 * queue.push(2);  </br>
 * queue.peek();  // 返回 1</br>
 * queue.pop();   // 返回 1</br>
 * queue.empty(); // 返回 false</br>
 * </p>
 * 
 * <p>
 * <strong>说明:</strong>
 * <li>你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。</li>
 * <li>你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。</li>
 * <li>假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。</li>
 * </p>
 * 
 * 
 * @author Cytus_
 * @since 2018年9月25日 下午5:25:35
 * @version 1.0
 */
public class _0232ImplementQueueUsingStacks {
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());
		System.out.println(queue.pop());
		System.out.println(queue.empty());
	}

	static class MyQueue {
		
		Stack<Integer> stack;

	    /** Initialize your data structure here. */
	    public MyQueue() {
	    	stack = new Stack<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	    	stack.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	    	int t = stack.firstElement();
	    	stack.removeElementAt(0);
	    	return t;
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	return stack.firstElement();
	        
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	    	return stack.isEmpty();
	    }
	}
	
}
