package BlockingQueue;

import java.util.concurrent.BlockingQueue;

import para.MyThread;

public class SafeDeliverer extends MyThread {

	private static int AMOUNT = 0;

	private final BlockingQueue<Integer> bq;

	private int count = 1;

	public SafeDeliverer(BlockingQueue<Integer> bq) {
		super("SafeDeliverer " + AMOUNT++);
		this.bq = bq;
	}

	@Override
	public void run() {
		printMessage("started");
		while (true) {
			boolean passed = bq.offer(count);
			// wenn bq nicht voll, count hinzufügen
			printMessage("offered " + count + "  |  passed: " + passed);
			count++;
			if (count > 5) {
				return;
			}
		}
	}

}
