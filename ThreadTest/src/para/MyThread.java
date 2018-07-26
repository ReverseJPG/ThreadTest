package para;

public class MyThread extends Thread {

	private static final short NAME_LENGTH = 20;

	private final String name;

	public MyThread(String name) {
		name += ":";
		for (int i = name.length(); i < NAME_LENGTH; i++) {
			name += " ";
		}
		this.name = name;
		
		Main.threads.add(this);
	}

	public void printMessage(String message) {
		System.out.println(name + message);
	}

}
