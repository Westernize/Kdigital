import java.util.Scanner;

public class Calculator {

    // 내부 클래스
    class Clac {
        int a;
        int b;

        void setvalue(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int calculate(char op) {
            switch (op) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    if (b == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        return 0;
                    }
                    return a / b;
                default:
                    System.out.println("지원하지 않는 연산자입니다.");
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("두 정수와 연산자를 입력하시오>>");

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        char op = sc.next().charAt(0);

        Calculator calculator = new Calculator(); // 외부 클래스 객체 생성
        Calculator.Clac calc = calculator.new Clac(); // 내부 클래스 객체 생성

        calc.setvalue(num1, num2); // 값 설정
        int result = calc.calculate(op); // 계산
        System.out.println("결과: " + result);
    }
}
