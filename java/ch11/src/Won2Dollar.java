import java.util.Scanner;

class Wo2Dollar {
    private int value;

    // Constructor (no return type)
    public Wo2Dollar(int v) {
        value = v;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("원을 입력하세요>> ");
        int won = sc.nextInt();
        double dollar = (double) won / value;
       System.out.println("변환결과:" + dollar + "달러 입니다.");
        sc.close();
    }
}

public class Won2Dollar {
    public static void main(String[] args) {
        Wo2Dollar toDollar = new Wo2Dollar(1200);
        toDollar.run();
    }
}
