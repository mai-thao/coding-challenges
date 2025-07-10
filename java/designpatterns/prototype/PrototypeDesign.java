package designpatterns.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All implementing classes must define the `clone()` method.
 */
interface Shape {
    Shape clone();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    /**
     * Clones the existing Rectangle with the same width and length, but it is a new instance with
     * its own memory space.
     */
    @Override
    public Shape clone() {
        return new Rectangle(width, height);
    }
}

class Square implements Shape {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    /**
     * Clones the existing Square with the same length, but it is a new instance with its own memory space.
     */
    @Override
    public Shape clone() {
        return new Square(length);
    }
}

class Test {
    /**
     * Given a list of shapes, clone them all and return a new list.
     */
    public List<Shape> cloneShapes(List<Shape> shapes) {
        List<Shape> clonedShapesList = new ArrayList<>();
        for (Shape shape: shapes) {
            clonedShapesList.add(shape.clone());
        }
        return clonedShapesList;
    }
}

/**
 * The Prototype is a creational design pattern that allows an object to copy itself. It is particularly
 * useful when the creation of an object is more convenient through copying an existing object than
 * through creation from scratch.
 */
public class PrototypeDesign {
    public static void main(String[] args) {
        Shape square = new Square(10); // 10 is the length
        Shape anotherSquare = square.clone(); // Clone with length 10
        System.out.println(square == anotherSquare); // false

        Shape rectangle = new Rectangle(10, 20); // 10 is width, 20 is height
        Shape anotherRectangle = rectangle.clone(); // Clone with width 10 and height 20
        System.out.println(rectangle == anotherRectangle); // false

        Test test = new Test();
        List<Shape> shapes = Arrays.asList(square, rectangle, anotherSquare, anotherRectangle);
        List<Shape> clonedShapes = test.cloneShapes(shapes);

        System.out.println(shapes == clonedShapes); // false
        System.out.println(shapes.size() == clonedShapes.size()); // true
        System.out.println(shapes.get(0) == clonedShapes.get(0)); // false
        System.out.println(((Square) shapes.get(0)).getLength() == ((Square) clonedShapes.get(0)).getLength()); // true
    }
}
