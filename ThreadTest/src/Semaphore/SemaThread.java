package Semaphore;

import java.util.concurrent.Semaphore;

import para.MyThread;

public class SemaThread extends MyThread {

	private static int AMOUNT = 0;
	
	private final Semaphore sema;

	public SemaThread(Semaphore sema) {
		super("SemaThread "+AMOUNT++);
		this.sema = sema;
	}

	@Override
	public void run() {
		printMessage("acquire");
		try {
			sema.acquire();
			printMessage("passed acquire");
		} catch (InterruptedException e) {
		}

		for (int i = 0; i < 2; i++) {
			printMessage("does Stuff "+i);
		}

		printMessage("release");
		sema.release();

	}

}
