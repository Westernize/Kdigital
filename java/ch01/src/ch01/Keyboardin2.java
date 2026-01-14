package ch01;

import java.util.Scanner;

public class Keyboardin2 {

	public static void main(String[] args) {
		Scanner stdln = new Scanner(System.in);
		System.out.println("이름과 나이, 몸무게를 공간으로 구분하여 입력:");
		String name = stdln.next();
		int i = stdln.nextInt();
		double d = stdln.nextDouble();
		System.out.println(name + "씨의 나이는" + i + "세이고");
		System.out.println("몸무게는" + d + "kg 입니다.");
		

	}

}
