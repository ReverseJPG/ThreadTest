package BlockingQueue;

import java.util.concurrent.BlockingQueue;

import para.MyThread;

public class Consumer extends MyThread {

	private static int AMOUNT = 0;
	
	private final BlockingQueue<Integer> bq;

	public Consumer(BlockingQueue<Integer> bq) {
		super("Consumer "+ AMOUNT++);
		this.bq = bq;
	}

	@Override
	public void run() {
		printMessage("started");
		Integer number = 1;
		while (number % 5 !=0) {
			try {
				number = bq.take();
				printMessage("took "+number);
			} catch (InterruptedException e) {
				//Wirft wenn Thread probleme hat
			}
		}
	}

}
