abstract class Shape{
	abstract void draw();
	abstract void computerArea(double a, double b);
}
class Rectangle1 extends Shape{
	void draw() {
		System.out.println("사각형을 그리는 기능");
		
	}
	void computerArea(double a, double b) {
		System.out.println("사각형의 넓이:" + (a * b));
	}
}

class Triangle1 extends Shape{

	@Override
	void draw() {
		System.out.println("삼각형을 그리는 기능");
		
	}

	@Override
	void computerArea(double a, double b) {
		System.out.println("삼각형의 넓이:" + (a * b / 2) );
		
	}
	
}
public class AbstractTest2 {

	public static void main(String[] args) {
		Shape r1 = new Rectangle1();
		r1.draw();
		r1.computerArea(5.0, 10.0);
		
		r1 = new Triangle1();
		r1.draw();
		r1.computerArea(5, 10);
	
	}

}
