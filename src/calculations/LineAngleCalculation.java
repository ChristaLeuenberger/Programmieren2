package calculations;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LineAngleCalculation {
        private static List<Coordinates> totalCoordinates = new LinkedList<>(); //Kevin: Wieso Alles?
        private Coordinates coordinates;
        private double[] imageRatio;


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
            double x;
            double y;
            Point2D.Double p1 = new Point2D.Double(); //Kevin: exotisch?
            Point2D.Double p2 = new Point2D.Double();
            Point2D.Double p3 = new Point2D.Double();
            for (int i = 0; i < totalCoordinates.size(); i++) {
                x = totalCoordinates.get(i).getX();
                y = totalCoordinates.get(i).getY();
                if (i == 0) {
                    p1 = new Point2D.Double(x, y);
                } else if (i == 1) {
                    p2 = new Point2D.Double(x, y);
                } else if (i == 2) {
                    p3 = new Point2D.Double(x, y);
                }
            }
            Point2D.Double vectorA = new Point2D.Double(p1.getX() - p2.getX(), p1.getY() - p2.getY());
            Point2D.Double vectorB = new Point2D.Double(p3.getX() - p2.getX(), p3.getY() - p2.getY());

            double length1 = Math.abs(Math.sqrt(vectorA.getX() * vectorA.getX() + vectorA.getY() * vectorA.getY()));
            double length2 = Math.abs(Math.sqrt(vectorB.getX() * vectorB.getX() + vectorB.getY() * vectorB.getY()));

            double angle = Math.toDegrees(
                    Math.acos((vectorA.getX() * vectorB.getX() + vectorA.getY() * vectorB.getY()) / (length1 * length2)));
            return angle;
        }

    }

