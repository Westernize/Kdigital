package ch02;

public class WhileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hap =0, count =1;
		while (count <=10) {
			hap += count;
			count +=1;
			
		}
		System.out.println("1부터 10까지 합은 " + hap + "입니다.");
	}

}
