package b_package;

import java.util.Scanner;

public class English {

	public static void main(String[] args) {
		System.out.print("소문자 알파벳 하나를 입력하세요>>");
	Scanner sc = new Scanner(System.in);
	char input = sc.next().charAt(0);
	for (char a = input; a>= 'a'; a--) {
		for(char b ='a'; a>=b; b++) {
		System.out.print(b);
	}
	System.out.println();
	}
	
	

	}
	}
		