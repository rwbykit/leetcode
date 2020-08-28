package leetcode;

import java.util.concurrent.Semaphore;

public class _1117BuildingH2O {

	
	class H2O {

		Semaphore oxygen = new Semaphore(2);
		Semaphore hydrogen = new Semaphore(1);
		
	    public H2O() {
	    }

	    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
	    	hydrogen.acquire();
	        releaseHydrogen.run();
	        oxygen.release();
	    }

	    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
	    	oxygen.acquire(2);
			releaseOxygen.run();
			hydrogen.release(2);
	    }
	}
	
}
