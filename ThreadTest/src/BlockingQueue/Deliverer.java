package BlockingQueue;

import java.util.concurrent.BlockingQueue;

import para.MyThread;

public class Deliverer extends MyThread {

	private static int AMOUNT = 0;
	
	private final BlockingQueue<Integer> bq;
	
	private int count = 1;

	public Deliverer(BlockingQueue<Integer> bq) {
		super("Deliverer "+ AMOUNT++);
		this.bq = bq;
	}

	@Override
	public void run() {
		printMessage("started.");
		while (true) {
			try {
				bq.put(count);
			} catch (InterruptedException e) {
				//Wirft wenn Thread kaputt geht, irgendwie manchmal auch wenn voll, sollte aber i.d.R. warten
			}
			printMessage(count+"");
			count++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count>5) {
				return;
			}
		}
	}

}
