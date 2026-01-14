class Rectangle5 {
    public int width;
    public int height;

    // 생성자 이름을 클래스 이름인 Rectangle5로 수정
    public Rectangle5(int w, int h) {
        width = w;
        height = h;
    }

    public int computeRectangleArea() {
        return width * height;
    }
}

class cube5 extends Rectangle5 {
    public int depth;

    public cube5(int w, int h, int d) {
        super(w, h);  // 부모 클래스의 생성자 호출
        depth = d;
    }

    public int computeCubeArea() {
        return super.computeRectangleArea() * depth;  // 면적 * 깊이로 부피 계산
    }
}

public class CastTest2 {
    public static void main(String args[]) {
        // Rectangle5 타입의 변수 r에 cube5 객체를 할당
        Rectangle5 r = new cube5(10, 20, 30);
        
        // 정사각형 면적 계산
        System.out.println("정사각형의 넓이는: " + r.computeRectangleArea());
        
        // r을 cube5 타입으로 강제 형변환
        cube5 c = (cube5) r;
        
        // 직육면체의 부피 계산
        System.out.println("직육면체의 부피는: " + c.computeCubeArea());
    }
}
