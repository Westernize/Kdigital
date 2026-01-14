package ch12;

public class ThreadNameEx {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("프로그램의 시작 스레드 이름:" + mainThread.getName());
		
		ThreadA ta = new ThreadA();
		System.out.println("작업 스레드 이름 :" + ta.getName());
		ta.start();
		ThreadA tb = new ThreadA();
		System.out.println("작업 스레드 이름 :" + tb.getName());
		tb.start();

	}

}
class ThreadA extends Thread{
	@Override
	public void run() {
		for(int i =0; i<2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
	}
}
