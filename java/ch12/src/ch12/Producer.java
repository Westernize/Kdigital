package ch12;

class Buffer {
	private int data;
	private boolean empty = true;
	
	public int get() {
		return data;
		
	}
	public void put(int data) {
		empty = false;
		this.data = data;
		
	}
}

class Pro implements Runnable{
	private Buffer buffer;
	
	public Pro(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<=10; i++) {
			buffer.put(i);
			System.out.println("제빵사가 :" + i + "번째 케잌을 만들었습니다.");
			try {
				Thread.sleep((int) (Math.random()*100));
			}catch(Exception e) {
				
			}
		}
		
		
	}
	
}
class Cu implements Runnable{
	
	private Buffer buffer;
	
	public Cu(Buffer buffer) {
		this.buffer = buffer;
	}
	@Override
	public void run() {
		for(int i = 1; i<=10; i++) {
			int data = buffer.get();
			System.out.println("소비자가 " + data + "케익을 샀습니다.");
			try {
				Thread.sleep((int) (Math.random()*100));
			}catch(Exception e) {
				
			}
		}
		
		
	}
	
	
}

public class Producer {
	public static void main(String[] args) {
		Buffer bu = new Buffer();
		(new Thread(new Pro(bu))).start();

	}

}
