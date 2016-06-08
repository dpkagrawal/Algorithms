package multi_threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
 // http://javarevisited.blogspot.com/2015/06/java-lock-and-condition-example-producer-consumer.html
	
public class ProducerConsumerProblem {
	public static void main(String[] args) throws InterruptedException{
//		BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>(20);
//
//		int count=100;
//		Thread t1 = new Thread(new Producer(queue, count));
//		Thread t2 = new Thread(new Consumer(queue, count));
//		t2.start();
//		t1.start();
//		
		Float f1 = 0.5f;
		Float f = 0.3f;
		
		System.out.println(f1%f);
	}
}
