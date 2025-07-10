package designpatterns.adapter;

/**
 *  We have the `SquareHole`, `Square` and `Circle` classes. A `Square` fits into a `SquareHole` if the `Square`'s
 *  side length is less than or equal to the `SquareHole`'s length. A `Circle` has a radius and a `Circle` fits
 *  into a `SquareHole` if the `Circle`'s diameter is less than or equal to the `SquareHole`'s length.
 *
 *  This demonstrates the usage of an `CircleToSquareAdapter` class such that it adapts a `Circle` to a `Square`.
 */
class SquareHole {
    private double sideLength;

    public SquareHole(double sideLength) {
        this.sideLength = sideLength;
    }

    public boolean canFit(Square square) {
        return this.sideLength >= square.getSideLength();
    }
}

class Square {
    private double sideLength;

    public Square() {}

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return this.sideLength;
    }
}

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}

class CircleToSquareAdapter extends Square {

    private Circle circle;

    public CircleToSquareAdapter(Circle circle) {
        this.circle = circle;
    }

    @Override
    public double getSideLength() {
        return 2 * this.circle.getRadius();
    }
}

/**
 * The Adapter is a structural design pattern that allows incompatible interfaces to work together. It wraps
 * an existing class with a new interface so that it becomes compatible with the client's interface.
 */
public class AdapterDesign {
    public static void main(String[] args) {
        SquareHole squareHole = new SquareHole(5);

        Square square = new Square(5);
        System.out.println(squareHole.canFit(square)); // true because 5 equals squarehole length 5

        Circle circle = new Circle(5);
        CircleToSquareAdapter circleAdapter = new CircleToSquareAdapter(circle);
        System.out.println(squareHole.canFit(circleAdapter)); // false because 2 * 5 = 10 which is greater than squarehole length 5

        System.out.println("--------");

        SquareHole squareHole2 = new SquareHole(5);

        Square square2 = new Square(6);
        System.out.println(squareHole2.canFit(square2)); // false because 6 is not less than squarehole length 5

        Circle circle2 = new Circle(2);
        CircleToSquareAdapter circleAdapter2 = new CircleToSquareAdapter(circle2);
        System.out.println(squareHole2.canFit(circleAdapter2)); // true because 2 * 2 = 4 which is less than squarehole length 5
    }
}
