package ch07;
class Cons3{
	public int num;
	public Cons3(String s) {
		System.out.println(s + " 명시적 생성자");
	}
	public Cons3(){
		System.out.println("..");
	}
}
public class ConTest3 {
	
	public static void main(String[] args) {
		Cons3 con = new Cons3("이병일");
		Cons3 con1 = new Cons3();
		
	}

}
