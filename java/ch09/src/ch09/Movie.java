package ch09;

import java.util.Scanner;

public class Movie {

    public static void main(String[] args) {
    	

        
        
        
        Scanner sc = new Scanner(System.in);
        System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
        int num = sc.nextInt();

        System.out.print("좌석구분 S(1), A(2), B(3) >> ");
        int seat = sc.nextInt();

     
        switch (seat) {
            case 1:
                System.out.println("S 좌석을 선택했습니다.");
                break;
            case 2:
                System.out.println("A 좌석을 선택했습니다.");
                break;
            case 3:
                System.out.println("B 좌석을 선택했습니다.");
                break;
            default:
                System.out.println("잘못된 좌석 선택입니다.");
                return; 
        }

      
        String[] name = new String[1];

        for (int y = 0; y < 1; y++) {
            System.out.print("이름 " + (y + 1) + ": ");
            name[y] = sc.next();
        

        String[] arr = new String[10]; 

        for (int i = 0; i < 10; i++) {
            arr[i] = "--- "; 
        }
        System.out.println(); 


        System.out.print("좌석번호 (1~10)을 선택하세요: ");
        int seatNumber = sc.nextInt() - 1; 

        if (seatNumber >= 0 && seatNumber < 10) {
            arr[seatNumber] = name[0];
        } else {
            System.out.println("잘못된 좌석번호입니다. 1~10 사이로 입력하세요.");
        }


        System.out.println("최종 좌석 배정:");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        
        
        }
      
    }
}
