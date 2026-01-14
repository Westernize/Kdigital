package ch02;

import java.util.Scanner;

public class WhileTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdin = new Scanner(System.in);
		int month;
		do {
			System.out.println("월을 입력하세요( 끝: 0)");
			month = stdin.nextInt();
			
			if ( 3 <= month&& month <= 5)
				System.out.println("봄 입니다.");
			else if ( 6<= month && month <=8)
				System.out.println("여름입니다.");
			else if ( 9<= month && month <=11)
			System.out.println("가을입니다.");
			else if ( 1== month || month == 2 || month ==12)
				System.out.println("겨울입니다.");
			else if (month != 0)
				System.out.println("잘못된 입력: 해당되는 계절이 없습니다.");
		}while (month != 0);
		System.out.println("감사합니다.");
	}

}
