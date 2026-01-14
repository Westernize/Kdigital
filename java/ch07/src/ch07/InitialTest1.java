package ch07;
class Initial {
	int number;
	double rate;
	String name;
	int[] score;
	public void aMethod() {
		int count;
		System.out.println(number);
		//System.out.println(count);
	}
	
}

public class InitialTest1 {
	public static void main(String[] args) {
		int var1;
		double var2;
		Initial ob1 = new Initial();
		//System.out.println("지역변수 var1의 값은" + var1);
		//System.out.println("지역변수 var2의 값은"+ var2);
		System.out.println("객체 변수 number:" + ob1.number);
		System.out.println("객체 변수 rate:" + ob1.rate);
		System.out.println("객체 변수 name:" + ob1.name);
		System.out.println("객체 변수 score:" + ob1.score);

	}

}
