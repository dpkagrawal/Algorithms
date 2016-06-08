package multi_threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counting implements Runnable {
//	volatile AtomicInteger count = new AtomicInteger();
	volatile int count =0;
	@Override
	public void run() {
		System.out.println("This is currently running on a separate thread, "
				+ "the id is: " + Thread.currentThread().getId());
		try {
			System.out.println("Current Count: " + count);
			Thread.sleep(50);
			synchronized(this) {
				//count.incrementAndGet();
				count++;
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Counting c = new Counting();
		List<Thread> l = new ArrayList<Thread>();
		for (int i = 0; i < 1000; i++) {
			Thread t1 = new Thread(c);
			l.add(t1);
			t1.start();
		}

		for(Thread t: l) {
			t.join();
		}

		System.out.println("Final Count: " + c.count);
	}
}
