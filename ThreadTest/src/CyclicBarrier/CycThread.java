package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import para.MyThread;

public class CycThread extends MyThread {

	private static int AMOUNT = 0;

	private final CyclicBarrier cb;

	public CycThread(CyclicBarrier cb) {
		super("CycThread " + AMOUNT++);
		this.cb = cb;
	}

	@Override
	public void run() {
		try {
			printMessage("await");
			/*
			 * System.out.println("Waiting: "+cb.getNumberWaiting());
			 * Die Ausgabe ist ein bisschen daneben und verwirrt nur, also mal weggelassen
			 */
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
		}
		printMessage("does sth");
	}
}
