
public class Triangle implements Shape{

    double a;
    double h;

    public Triangle (double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public String getFigureName() {
        return "triangle";
    }

    @Override
    public Double getArea() {
        return a * 0.5 * h;
    }
}

