package HW2;

public class Shape {
    private int a;
    private int b;
    public void printArea() {
    }
}

public class Rectagle extends Shape {
    public void printArea() {
        System.out.println("Area of rectangle is " + (a * b));
    }
}

public class Triangle extends Shape {
    public void printArea() {
        System.out.println("Area of triangle is " + (0.5 * a * b));
    }
}

public class Circle extends Shape {
    public void printArea() {
        System.out.println("Area of circle is " + (3.14 * a * a));
    }
}