package ch02;

import java.util.Scanner;

public class Seven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		
		while (run) {
			System.out.println("------------------------");
			System.out.println(("1.예금 | 2.출금 | 3.잔고 | 4.종료"));
			System.out.println("------------------------");
			System.out.print("선택 >");
			String num = scanner.nextLine();
			
			switch(num) {
		    case "1":
		        System.out.print("예금액>");
		        int num1 = scanner.nextInt();
		        balance += num1;
		        scanner.nextLine();
		        break;
		    
		    case "2":
		        System.out.print("출금액>");
		        int num2 = scanner.nextInt();
		        balance -= num2;
		        scanner.nextLine();
		        break;
		    
		    case "3":
		        System.out.println("잔고: " + balance);
		        break;
		        
		    
		    case "4":
		        run = false;
		        break;
		    
		    default:
		        System.out.println("잘못된 입력입니다.");
		        break;
		}
			
		}
		}
		
	

	}

 