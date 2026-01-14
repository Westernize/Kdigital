package ch07;

class Box3 {
	int width;
	int height;
	int depth;
	long idNum;
	static long BoxId = 0;
	public Box3() {
		idNum = ++BoxId;
	}
}
public class Box3Test1 {
	public static void main(String[] args) {
		Box3 mybox1 = new Box3();
		Box3 mybox2 = new Box3();
		Box3 mybox3 = new Box3();
		Box3 mybox4 = new Box3();
	
		
		System.out.println("mybox1의 id의 번호:" + mybox1.idNum);
		System.out.println("mybox2의 id의 번호:" + mybox2.idNum);
		System.out.println("mybox3의 id의 번호:" + mybox3.idNum);
		System.out.println("mybox4의 id의 번호:" + mybox4.idNum);
		System.out.println("마지막 생성된 박스 번호는" + Box3.BoxId + "번호 입니다.");


	}

}
