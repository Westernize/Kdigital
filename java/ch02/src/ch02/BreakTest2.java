package ch02;

public class BreakTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i , j;
		
		for (i = 1; i< 10; i++) {
			
		
		for (j = 1; j< i; j++) 
		{
			if ( j> 6) break;
			System.out.print("*");
		}
		System.out.println();
		}
	}

}
