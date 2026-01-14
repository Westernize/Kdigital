package ch09;
class Box12{
	private int ivol;
	public Box12(int w , int h, int d)
	{
		ivol = w * h * d;
	}
	public String get_ivol() {
		return "박스의 부피는" +ivol;
	}
}

public class Box2Test1 {

}
