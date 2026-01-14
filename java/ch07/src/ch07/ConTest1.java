package ch07;

class Cons1 {
	public int num;
	
	public void Cons1() {
		System.out.println("묵시적 생성자");
	}
}
public class ConTest1 {

	public static void main(String[] args) {
		Cons1 cons = new Cons1();
		cons.Cons1();
	}

}
