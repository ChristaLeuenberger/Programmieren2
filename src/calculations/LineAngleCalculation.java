package calculations;

import java.util.LinkedList;
import java.util.List;


import javafx.geometry.Point2D;

public class LineAngleCalculation {

    private static List<Coordinates> totalCoordinates = new LinkedList<>();


    public LineAngleCalculation() {
    }

    public List<Coordinates> getTotalCoordinates() {
        return totalCoordinates;
    }

    public void addCoordinates(Coordinates coordinates) {
        totalCoordinates.add(coordinates);
    }

    public void removeCoordinates() {
        totalCoordinates.clear();
    }

    public double calculateLength(double[] imageRation) {
        double lengthX;
        double lengthY;
        double lengthTotal = 0.0;
        for (int i = 0; i < (totalCoordinates.size() - 1); i++) {
            lengthX = (Math.abs(totalCoordinates.get(i).getX() - totalCoordinates.get(i + 1).getX())) * imageRation[0];
            lengthY = (Math.abs(totalCoordinates.get(i).getY() - totalCoordinates.get(i + 1).getY())) * imageRation[1];

            lengthTotal += Math.sqrt((lengthX * lengthX) + (lengthY * lengthY));

        }

        return lengthTotal;
    }

    public double calculateAngle() {
        Point2D p1, p2, p3;
        p1 = new Point2D(totalCoordinates.get(0).getX(), totalCoordinates.get(0).getY());
        p2 = new Point2D(totalCoordinates.get(1).getX(), totalCoordinates.get(1).getY());
        p3 = new Point2D(totalCoordinates.get(2).getX(), totalCoordinates.get(2).getY());
        double angleTotal = p2.angle(p1, p3);

        return (Math.round(angleTotal * 10.0) / 10.0);
    }
}

