package multi_threading;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	BlockingQueue<Integer> q;
	int size;
	int maxSize;

	Producer(BlockingQueue<Integer> q, int size) {
		this.q = q;
		this.size = size;
		this.maxSize = 20;
	}

	@Override
	public void run() {
		while(size>0){
			System.out.println("Adding element: " + size);
			try {
				q.put(size--);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}