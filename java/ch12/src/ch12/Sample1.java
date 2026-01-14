package ch12;



public class Sample1 extends Thread {
	
	int seq;
	public Sample1(int i) {
		seq = i;
	}
	
	public void run() {
		System.out.println(seq + " tread Start.");
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		System.out.println(seq + " tread end.");
	}
	public static void main(String[] args) {
		for(int i = 1; i<=10; i++) {
			Thread t = new Sample1(i);
			t.run();
		}
		System.out.println("메인 종료")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ;

		
		
	}

}
