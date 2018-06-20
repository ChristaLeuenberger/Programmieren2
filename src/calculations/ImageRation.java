package calculations;

import javafx.geometry.Bounds;

public class ImageRation {
    private Bounds fittedImageSize;
    private double trueImageWidth;
    private double trueImageHeight;

    public ImageRation(Bounds fittedImageSize, double trueImageWidth, double trueImageHeight) {
        this.fittedImageSize = fittedImageSize;
        this.trueImageWidth = trueImageWidth;
        this.trueImageHeight = trueImageHeight;
    }

    public double[] calculateImageRation() {
        double[] ration = new double[2];
        ration[0] = trueImageWidth / fittedImageSize.getWidth();
        ration[1] = trueImageHeight / fittedImageSize.getHeight();
        return ration;
    }
}

