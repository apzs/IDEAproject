import static java.lang.Math.sqrt;
public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;
    private boolean isTriangle =true;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if(side1+side2<=side3||side1+side3<=side2||side2+side3<=side1) {
            this.isTriangle = false;
        }
    }

    @Override
    public double area() {
        if(isTriangle) {
            double p = (side1 + side2 + side3) / 2;
            return sqrt(p * (p - side1) * (p - side2) * (p - side3));
        }else {
            System.out.println("无法计算面积");
            return -1;
        }
    }

    @Override
    public double perimeter() {
        if(isTriangle) {
            return side1 + side2 + side3;
        }else {
            System.out.println("无法计算周长");
            return -1;
        }
    }

    @Override
    public void setColor() {
        if (isTriangle) {
            System.out.println("改变三角形的颜色");
        }else {
            System.out.println("无法改变颜色");
        }
    }
}
