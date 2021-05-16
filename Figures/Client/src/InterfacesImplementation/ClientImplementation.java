package InterfacesImplementation;

import Interfaces.Operations;
import Interfaces.Shapes;
import Objects.Circle;
import Objects.Rectangle;
import Objects.Square;
import Objects.Triangle;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientImplementation {

    public void connectSever () {

        try {
            Triangle triangle;
            Circle circle;
            Rectangle rectangle;
            Square square;

            double base, side1, side2, height, radius, side;
            double area, perimeter, circumference;

            Scanner input = new Scanner(System.in);
            int option;

            Registry registry = LocateRegistry.getRegistry("localhost", 7777);
            Shapes shapes = (Shapes) registry.lookup("RMIShapes");
            Operations operations = (Operations) registry.lookup("RMIOperations");

            do {
                System.out.println("Choose a figure:\n"
                        + "1) Triangle\n"
                        + "2) Circle\n"
                        + "3) Rectangle\n"
                        + "4) Square\n"
                        + "5) Exit");
                option = input.nextInt();

                switch (option) {

                    case 1:

                        System.out.print("Input the base: ");
                        base = input.nextDouble();

                        System.out.print("Input a side of the triangle: ");
                        side1 = input.nextDouble();

                        System.out.print("Input the other side of the triangle: ");
                        side2 = input.nextDouble();

                        System.out.print("Input the height of the triangle: ");
                        height = input.nextDouble();

                        triangle = (Triangle) shapes.getTriangle(base, side1, side2, height);

                        perimeter = operations.perimeterTriangle(triangle.getBase(), triangle.getSide1(), triangle.getSide2());
                        area = operations.areaTriangle(triangle.getBase(), triangle.getSide1(), triangle.getSide2(), triangle.getHeight());

                        System.out.println("The area of the triangle is " + area + ".");
                        System.out.println("The perimeter of the triangle is " + perimeter + ".\n");

                    break;

                    case 2:

                        System.out.print("Input the radius of the circle: ");
                        radius = input.nextDouble();

                        circle = (Circle) shapes.getCircle(radius);

                        circumference = operations.circumferenceCircle(circle.getRadius());
                        area = operations.areaCircle(circle.getRadius());

                        System.out.println("The area of the circle is " + area + ".");
                        System.out.println("The circumference of the circle is " + circumference + ".\n");

                    break;


                    case 3:

                        System.out.print("Input a side of the rectangle: ");
                        side1 = input.nextDouble();

                        System.out.print("Input the other side of the rectangle: ");
                        side2 = input.nextDouble();

                        rectangle = (Rectangle) shapes.getRectangle(side1, side2);

                        perimeter = operations.perimeterRectangle(rectangle.getSide1(), rectangle.getSide2());
                        area = operations.areaRectangle(rectangle.getSide1(), rectangle.getSide2());

                        System.out.println("The area of the triangle is " + area + ".");
                        System.out.println("The perimeter of the triangle is " + perimeter + ".\n");

                    break;

                    case 4:

                        System.out.print("Input the side of the square: ");
                        side = input.nextDouble();

                        square = (Square) shapes.getSquare(side);

                        perimeter = operations.perimeterSquare(square.getSide());
                        area = operations.areaSquare(square.getSide());

                        System.out.println("The area of the square is " + area + ".");
                        System.out.println("The circumference of the square is " + perimeter + ".\n");

                    break;

                    case 5:

                        System.out.println("Goodbye!");

                    break;
                }

            } while (option != 5);

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }

}
