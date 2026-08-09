class Shape {

    void display() {
        System.out.println("This is a Shape");
    }
}

// Circle inherits Shape
class Circle extends Shape {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void calculateArea() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

// Rectangle inherits Shape
class Rectangle extends Shape {

    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    void calculateArea() {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

public class ShapeApplication {

    public static void main(String[] args) {

        Circle c = new Circle(5);

        System.out.println("Circle:");
        c.display();
        c.calculateArea();

        Rectangle r = new Rectangle(10, 5);

        System.out.println("\nRectangle:");
        r.display();
        r.calculateArea();
    }
}