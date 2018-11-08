import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;


public interface Imageoperations {


    public static Mat grayscale(Mat imageMat ){

        Mat grayImg = new Mat();
        Imgproc.cvtColor(imageMat,grayImg,Imgproc.COLOR_BayerBG2BGR);

        return grayImg;
    }
    public static Mat gaussianBlur (Mat imageMat){

        Mat gausImg = new Mat();
        Size size = new Size(3,3);

        Imgproc.GaussianBlur(imageMat,gausImg,size,15);

        return gausImg;
    }

    public static Mat medianblur(Mat imageMat){

         Mat medianImg = new Mat();
         Imgproc.medianBlur(imageMat,medianImg,5);

        return medianImg;
    }



    public static Mat  sobelEdges(Mat imageMat){

        if (imageMat.equals(null)){
            System.out.println("The source image is empty");
            return null;
        }else {

            Mat gausSrc = gaussianBlur(imageMat);
            Mat graySrc = grayscale(gausSrc);
            Mat sobelImgX = new Mat();
            Mat sobelImgY = new Mat();
            Mat sobelFinal = new Mat();

            //Gradient X
            Imgproc.Sobel(graySrc,sobelImgX,CvType.CV_16S,1,0,3,1,0,Core.BORDER_DEFAULT);
            //Gradient Y
            Imgproc.Sobel(graySrc,sobelImgY,CvType.CV_16S,0,1,3,1,0,Core.BORDER_DEFAULT);

            Core.addWeighted(sobelImgX,0.5,sobelImgY,0.5,0,sobelFinal);

            return sobelFinal;
        }
    }

    public static Mat colorLabeling(Mat ImageMat){

        Mat Gaus = gaussianBlur(ImageMat);

        Scalar lowerGreen = new Scalar(10,30,10);
        Scalar upperGreen = new Scalar(40,255,40);

        Scalar lowerRed = new Scalar(30,10,10);
        Scalar upperRed = new Scalar(255,40,40);

        Scalar lowerBlue = new Scalar(10,10,30);
        Scalar upperBlue = new Scalar(40,40,255);

        


         return ImageMat;




    }


}
