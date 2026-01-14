package ch07;
class Box4{
	int width;
	int height;
	int depth;
	public Box4(int w, int h, int d)
	{
		width = w;
		height = h;
		depth = d;
		
	}
}
public class Box4Test1 {
	public static void main(String[] args) {
		Box4 mybox = new Box4(10,20,30);
		int vol = mybox.width * mybox.height * mybox.depth;
		System.out.println("박스의 부피:" + vol);


	}

}
