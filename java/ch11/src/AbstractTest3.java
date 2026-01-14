import java.awt.geom.Rectangle2D;

abstract class Figure {
	abstract void draw();
}
class Triangle2 extends Figure{
	public void draw() {
		System.out.println("다형성: 삼각형을 그린다.");
	}
class Rectangle2 extends Figure{
	public void draw() {
		System.out.println("다형성: 사각형을 그린다.");
	}
}
class Oval2 extends Figure{
	public void draw() {
		System.out.println("다형성: 사각형을 그린다.");
	}
	class Polydrwa {
		public void pdraw(Figure f) {
			f.draw();
		}
	}
	public void pdraw(Triangle2 t) {
		t.draw();
	}
	public void pdraw (Rectangle2 r) {
		r.draw();
	}
	public void pdraw (Oval2 o) {
		o.draw();
	}
	
}
}
public class AbstractTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
