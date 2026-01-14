package ch07;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("얼마를 예치하시겠습니까?");
		int money = sc.nextInt();
		System.out.print("몇년 예치하시겠습니까?");
		int year = sc.nextInt();
		System.out.print("이율은 몇 %로 하시겠습니까?");
		double percent = sc.nextDouble();
		
		double rate = percent / 100.0;

        double compoundInterest = money * Math.pow(1 + rate, year);
        System.out.print(year + "년 후에 총 금액이 " + compoundInterest + "원 입니다.");
    }
		
		

	}

