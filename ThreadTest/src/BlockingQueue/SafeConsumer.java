package BlockingQueue;

import java.util.concurrent.BlockingQueue;

import para.MyThread;

public class SafeConsumer extends MyThread {

	private static int AMOUNT = 0;

	private final BlockingQueue<Integer> bq;

	public SafeConsumer(BlockingQueue<Integer> bq) {
		super("SafeConsumer " + AMOUNT++);
		this.bq = bq;
	}

	@Override
	public void run() {
		printMessage("started");
		Integer number = 1;
		while (number == null || number % 5 != 0) {
			number = bq.poll();
			//Wenn bq leer, dann number = null und wird nicht blockiert
			if (number != null) {
				printMessage(number + "");
				return;
				//damit nicht ewig läuft
			}
		}
	}

}
