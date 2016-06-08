package multi_threading;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLocks {
	Lock lock = new ReentrantLock();
	Condition bufferFull = lock.newCondition();
	Condition bufferEmpty = lock.newCondition();
	Queue<Integer> que = new PriorityQueue<Integer>();
	private static final Integer MAX_CAPACITY = 10;
	int i = 0;

	void put() {
		lock.lock();
		try {
			while (que.size() > MAX_CAPACITY) {
				bufferFull.await();
			}
			que.offer(i++);
			bufferEmpty.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	void get() {
		lock.lock();
		try {
			while (que.isEmpty()) {
				bufferEmpty.await();
			}
			
			que.poll();
			bufferFull.notify();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			lock.unlock();
		}
	}
}
