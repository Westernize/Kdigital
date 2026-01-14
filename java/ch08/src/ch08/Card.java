package ch08;

import java.util.Random;
import java.util.Scanner;

public class Card {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean game = true;

        while (game) {
            System.out.println("수를 결정하였습니다. 맞추어보세요!");
            Random r = new Random();
            int k = r.nextInt(100); 
            int n = 0;

            for (int i = 1; i <= 5; i++) {
                System.out.print(i + ">> ");
                try {
                    n = sc.nextInt();

                    if (n < 0 || n > 99) {
                        System.out.println("잘못 입력하였습니다. 0~99 사이의 수를 입력하세요.");
                        i--; 
                        continue;
                    }

                    if (n == k) {
                        System.out.println("맞았습니다!");
                        break;
                    } else if (n < k) {
                        System.out.println("더 높게");
                    } else {
                        System.out.println("더 낮게");
                    }

                  

                } catch (Exception e) {
                    System.out.println("숫자를 입력하세요!");
                    sc.next(); 
                    i--; 
                }
            }

            System.out.print("다시 하시겠습니까?(y/n) >> ");
            String answer = sc.next();
            if (!answer.equalsIgnoreCase("y")) {
                game = false;
                System.out.println("게임을 종료합니다.");
            }
        }

        sc.close();
    }
}
