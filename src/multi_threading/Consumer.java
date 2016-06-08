package multi_threading;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
	BlockingQueue<Integer> q;
	int size;

	Consumer(BlockingQueue<Integer> q, int size) {
		this.q = q;
		this.size = size;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Processing item: " + q.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}