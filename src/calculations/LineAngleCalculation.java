package calculations;

import datamodel.DataLoader;
import datamodel.DataModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javafx.geometry.Point2D;

public class LineAngleCalculation {
    private static final Logger logger = Logger.getLogger( LineAngleCalculation.class.getName() );
        private static List<Coordinates> totalCoordinates = new LinkedList<>();
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
                logger.info("Ration width"+imageRation[0]);
                logger.info("Ration hight"+imageRation[1]);
                lengthTotal += Math.sqrt((lengthX * lengthX) + (lengthY * lengthY));
                logger.info("lengthTotal"+lengthTotal);
            }

            return lengthTotal;
        }

        public double calculateAngle() {
            Point2D p1 = null;
            Point2D p2 = null;
            Point2D p3 = null;
            Point2D p4 = null;
            for (int i = 0; i < totalCoordinates.size(); i++) {

            p1 = new Point2D(totalCoordinates.get(i).getX(), totalCoordinates.get(i).getY());
            p2 = new Point2D(totalCoordinates.get(i).getX(), totalCoordinates.get(i).getY());
            p3 = p2.subtract(p1);
            p4 = new Point2D(1, 0);}

            double angleTotal = p4.angle(p3);
            angleTotal = Math.toDegrees(Math.atan2(p2.getY() - p1.getY(),  p2.getX() - p1.getX()));
            logger.info("angle"+angleTotal);

            return angleTotal;


        }}

            /*double x;
            double y;
            Point2D.Double p1 = new Point2D.Double(); //Kevin: exotisch?
            Point2D.Double p2 = new Point2D.Double();
            Point2D.Double p3 = new Point2D.Double();
            for (int i = 0; i < totalCoordinates.size(); i++) {
                x = totalCoordinates.get(i).getX();
                y = totalCoordinates.get(i).getY();
                if (i == 0) {
                    v1 = new Point2D.Double(x, y);
                } else if (i == 1) {
                    v2 = new Point2D.Double(x, y);
                } else if (i == 2) {
                    v3 = new Point2D.Double(x, y);
                }
            }
            Point2D.Double vectorA = new Point2D.Double(v1.getX() - v2.getX(), v1.getY() - v2.getY());
            Point2D.Double vectorB = new Point2D.Double(v3.getX() - v2.getX(), v3.getY() - v2.getY());

            double length1 = Math.abs(Math.sqrt(vectorA.getX() * vectorA.getX() + vectorA.getY() * vectorA.getY()));
            double length2 = Math.abs(Math.sqrt(vectorB.getX() * vectorB.getX() + vectorB.getY() * vectorB.getY()));

            double angle = Math.toDegrees(
                    Math.acos((vectorA.getX() * vectorB.getX() + vectorA.getY() * vectorB.getY()) / (length1 * length2)));
            return angle;
        }

    }*/

