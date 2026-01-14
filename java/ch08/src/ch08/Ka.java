package ch08;

import java.util.Scanner;

public class Ka {
    public static void main(String[] args) {
        String[] str = {"가위", "바위", "보"};
        Scanner sc = new Scanner(System.in);

        System.out.println("컴퓨터와 가위바위보 게임을 합니다. (종료하려면 '종료'를 입력하세요)");

        while (true) {
            System.out.print("가위 바위 보! >> ");
            String a = sc.nextLine();

        
            if (a.equals("종료")) {
                System.out.println("게임을 종료합니다.");
                break;
            }

   
            int n = (int) (Math.random() * 3);

            System.out.println("사용자 = " + a + ", 컴퓨터 = " + str[n]);

     
            if (a.equals(str[n])) {
                System.out.println("비겼습니다!");
            } else if ((a.equals("가위") && str[n].equals("보")) ||
                       (a.equals("바위") && str[n].equals("가위")) ||
                       (a.equals("보") && str[n].equals("바위"))) {
                System.out.println("사용자가 이겼습니다!");
            } else if (a.equals("가위") || a.equals("바위") || a.equals("보")) {
                System.out.println("컴퓨터가 이겼습니다!");
            } else {
                System.out.println("잘못된 입력입니다. '가위', '바위', '보', 또는 '종료'를 입력하세요.");
            }
        }

        sc.close();
    }
}
