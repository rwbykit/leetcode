package leetcode;

/**
 * 我们提供一个类：

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}

两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。

请设计修改程序，以确保 "foobar" 被输出 n 次。

 

示例 1:

输入: n = 1
输出: "foobar"
解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。

示例 2:

输入: n = 2
输出: "foobarfoobar"
解释: "foobar" 将被输出两次。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/print-foobar-alternately
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author Cytus_
 * @since 2019年8月23日 下午2:17:49
 * @version 1.0
 */
public class _1115PrintFoobarAlternately {

	 FooBar f = new FooBar(5);
	
	 static class FooBar {
	    private int n;
	    
	    java.util.concurrent.Semaphore foo = new java.util.concurrent.Semaphore(0);
		java.util.concurrent.Semaphore bar = new java.util.concurrent.Semaphore(1);

	    public FooBar(int n) {
	        this.n = n;
	    }

	    public void foo(Runnable printFoo) throws InterruptedException {
	        
	        for (int i = 0; i < n; i++) {
	            
	        	// printFoo.run() outputs "foo". Do not change or remove this line.
	            bar.acquire();
	            printFoo.run();
	            foo.release(1);
	        	
	        }
	    }

	    public void bar(Runnable printBar) throws InterruptedException {
	        
	        for (int i = 0; i < n; i++) {
	            
	            // printBar.run() outputs "bar". Do not change or remove this line.
	            foo.acquire();
	        	printBar.run();
	            bar.release();
	        }
	    }
	}
	
}
