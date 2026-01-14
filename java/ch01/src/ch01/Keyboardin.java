package ch01;

import java.io.IOException;
import java.util.Scanner;

//import java.util.Scanner;
public class Keyboardin {
		
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		double cm;
		double kg;
		double BMI;
		System.out.println("신장:");
		cm = sc.nextDouble();
		System.out.println("체중");
		kg = sc.nextDouble();
	
		BMI = kg/ (cm*cm);
		
		if (BMI < 20) {
		    System.out.println("저체중");
		} else if (20 <= BMI && BMI <= 24) {
		    System.out.println("정상");
		}

		System.out.println("BMI 결과ㅣ"+ BMI);
		
	}


	}
