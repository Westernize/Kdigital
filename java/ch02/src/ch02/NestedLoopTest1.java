package ch02;

public class NestedLoopTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i =2;
		while ( i <= 9)
		{
			System.out.println("***" + i + "단 ***");
			for ( int j =1 ; j <= 9; j ++) 
			{
				System.out.println(i + "x" + j + "=" + i*j);
			}
			System.out.println();
			i++;
		}

	}

}
