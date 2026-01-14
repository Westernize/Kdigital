class Rectangle4 {
    public int width;
    public int height;

  
    public Rectangle4(int w, int h) {
        width = w;
        height = h;
    }

    public int computeRectangleArea() {
        return width * height;
    }
}

class Cube4 extends Rectangle4 {
    public int depth;


    public Cube4(int w, int h, int d) {
        super(w, h);  // Calls the constructor of Rectangle4
        depth = d;
    }


    public int computeCubeArea() {
        return computeRectangleArea() * depth; // Uses method from Rectangle4
    }
}

public class Racktangle4 {
    public static void main(String[] args) {

        Cube4 c = new Cube4(10, 20, 30);


        System.out.println("넓이는: " + c.computeRectangleArea());


        System.out.println("넓이는: " + c.computeCubeArea());
    }
}
