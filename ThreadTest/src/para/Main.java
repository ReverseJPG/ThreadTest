package para;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

import BlockingQueue.Consumer;
import BlockingQueue.Deliverer;
import BlockingQueue.SafeConsumer;
import BlockingQueue.SafeDeliverer;
import Semaphore.SemaThread;

public class Main {
	
	public static List<Thread> threads = new ArrayList<>();
	//werden in MyThread geadded
	
	public static void main(String args[]) throws InterruptedException {
		//Sema Code
		System.out.println("-----Semaphore-----\n");
		Semaphore sem = new Semaphore(2);
		
		for(int i = 0; i<5;i++) {
			new SemaThread(sem).start();
		}
		
		clear();
		
		//BlockingQueue Code
		System.out.println("\n\n-----BlockingQueue-----\n");
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
		for(int i = 0; i<2;i++) {
			new Deliverer(bq).start();
			new SafeDeliverer(bq).start();
			new Consumer(bq).start();
			new SafeConsumer(bq).start();
		}
		
		clear();
		
	}
	
	private static void clear() {
		threads.forEach(Thread -> {
			try {
				Thread.join();
			} catch (InterruptedException e) {
			}
		});
		threads.clear();
	}
	
}
