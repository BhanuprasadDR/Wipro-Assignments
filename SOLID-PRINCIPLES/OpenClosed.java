public class OpenClosed {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape square = new Square(4);

        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Circle Area: " + calculator.calculate(circle));
        System.out.println("Square Area: " + calculator.calculate(square));
    }
}

interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Square implements Shape {
    private double side;
    public Square(double side) {
        this.side = side;
    }
    public double area() {
        return side * side;
    }
}

class AreaCalculator {
    public double calculate(Shape shape) {
        return shape.area();
    }
}
