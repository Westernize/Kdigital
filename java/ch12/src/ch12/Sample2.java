package ch12;

class TimeThread extends Thread{
	int n =0;
	
	@Override
	public void run() {
		while(true) {
		System.out.println(n);
		n++;
		try {
			sleep(1000);
		}
		catch(InterruptedException e) {return;}
		}
	}
}
public class Sample2 {
	public static void main(String[] args) {
		TimeThread th = new TimeThread();
		th.start();
	}
}
