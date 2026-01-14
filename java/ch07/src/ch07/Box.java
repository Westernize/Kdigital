package ch07;

public class Box {
	int width;
	int height;
	int depth;
	public Box(int w, int h, int d)
	{
		width = w;
		height = h;
		depth = d;

	}
	public void volume() {

		int vol;
		vol = width * height * depth;
		System.out.println("Volume is " + vol);
	}

}
