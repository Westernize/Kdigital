package ch02;

public class BreakExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			 int num = (int) (Math.random() *6)+1;
			 System.out.println(num);
			 if (num == 6) {
				 break;
			 }
		}
		 System.out.println("프로그램을 종료합니다.");
	}

}
