package ch10;
class C1{
	private static int x = 100;
	static int z = x;
	public static int cc() {return x;}
}
class C2 extends C1{
	public static String x;
	static int y;
}


class InheritanceTest3 {
	public static void main(String[] args) {
		System.out.println("클래스 메소드 c1.cc() 값:" + C1.cc());

	}

}
