abstract class Figure1{
	abstract void draw();
}
interface shape1{
	public void computerArea(double a, double b);
}
class Triangle3 extends Figure1 implements shape1{

	@Override
	public void computerArea(double a, double b) {
		System.out.println("삼각형 넓이 :" + (a * b /2));	
	}
	@Override
	void draw() {
		System.out.println("삼각형을 그리는 기능");
		
		
	}
	
}

class Rectangle3 extends Figure1 implements shape1 {

	@Override
	public void computerArea(double a, double b) {
		System.out.println("사각형 넓이 :" + (a * b) );
		
	}

	@Override
	void draw() {
		System.out.println("사각형을 그리는 기능");

		
	}
	
}

class Oval3 extends Figure1 implements shape1{

	@Override
	public void computerArea(double a, double b) {
		System.out.println("원의 넓이:"+ (3.14 * a*b));
		
	}

	@Override
	void draw() {
		System.out.println("원을 그리는 기능");
		
	}
	
}
class Polydraw1{
	public void pdraw(Figure1 f ) {
		f.draw();
	}
	public void pcomputerArea(shape1 s , double a, double b) {
		s.computerArea(a, b);
	}
}

public class InterfaceTest2 {

	public static void main(String[] args) {
		Polydraw1 p = new Polydraw1();
		Figure1 fg1 = new Triangle3();
		Figure1 fg2 = new Rectangle3();
		Figure1 fg3 =  new Oval3();
		
		shape1 sp1 = new Triangle3();
		shape1 sp2 = new Rectangle3();
		shape1 sp3 = new Oval3();
		
		p.pdraw((fg1));
		p.pcomputerArea(sp1, 4, 4);
		
		p.pdraw(fg2);
		p.pcomputerArea(sp2, 4, 4);
		
		p.pdraw(fg3);
		p.pcomputerArea(sp3, 4, 4);

	}

}
