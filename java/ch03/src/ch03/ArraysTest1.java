package ch03;

import java.util.Scanner;  // Scanner 클래스 임포트

public class ArraysTest1 {

    public static void main(String[] args) {
     
        Scanner stdin = new Scanner(System.in); 

      
        double[] drum = new double[5];

   
        System.out.println("drum의 배열의 길이: " + drum.length);

    
        System.out.print("초기화 하지 않은 drum[]의 값: ");
        for (int i = 0; i < drum.length; i++) {
            System.out.print(drum[i] + " ");
        }

        System.out.println(); 


        for (int i = 0; i < drum.length; i++) {
            System.out.println("drum[" + i + "]번째 데이터 입력");
            drum[i] = stdin.nextDouble(); 
        }

       
        System.out.println("입력된 drum 배열의 값:");
        for (int i = 0; i < drum.length; i++) {
            System.out.print(drum[i] + " ");
        }

        stdin.close();  
    }
}
