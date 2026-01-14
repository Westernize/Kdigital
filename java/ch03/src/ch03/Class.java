package ch03;
import java.util.Scanner;

public class Class {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int studentNum = 0;
        int[] scores = null;

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("----------------------------------------");
            System.out.print("선택> ");
            
            int num = sc.nextInt();
            switch(num) {
                case 1:
                    System.out.print("학생수> ");
                    studentNum = sc.nextInt();
                    scores = new int[studentNum];
                    break;  

                case 2:
                    if (scores == null) {
                        System.out.println("학생 수를 먼저 입력하세요.");
                        break;
                    }
                    for (int i = 0; i < studentNum; i++) {
                        System.out.print((i + 1) + "번 학생의 점수> ");
                        scores[i] = sc.nextInt();
                    }
                    break; 


                case 3:
                    if (scores == null) {
                        System.out.println("점수를 입력하세요.");
                        break;
                    }
                    for (int i = 0; i < studentNum; i++) {
                        System.out.println((i + 1) + "번 학생의 점수> " + scores[i]);
                    }
                    break; 
                    
                    
                case 4:
                    if (scores == null) {
                        System.out.println("점수를 입력하세요.");
                        break;
                    }
                    int max = scores[0];
                    int total = 0;
                    for (int i = 1; i < studentNum; i++) {
                        if (scores[i] > max) {
                            max = scores[i];
                            total += scores[i]; 
                    
                        }
                        double average = (double) total / studentNum;
                        System.out.println("최고 점수: " + max);
                        System.out.println("평균:" + average);
                    }
            
                    break; 

                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;  

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
