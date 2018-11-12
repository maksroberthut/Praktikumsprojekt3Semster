import com.jogamp.common.nio.ByteBufferInputStream;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.beans.VetoableChangeListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

public class Main extends OpenJPanel{


    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main (String[] args){
        FacePanel facePanel = new FacePanel();
        JFrame screen = new JFrame();
        screen.setVisible(true);
        screen.setSize(800,800);
        screen.setVisible(true);
        screen.setContentPane(facePanel);

        MatToBufferedImage matToBufferedImageConverter = new MatToBufferedImage();


        Mat mat = new Mat();
        VideoCapture camera = new VideoCapture();
        camera.open(0);

        if(!camera.isOpened()){
            System.out.println("Stream Opening Error");
           // JOptionPane.showMessageDialog(null,"Please check you'r Device", "Camera",JOptionPane.INFORMATION_MESSAGE);
        }
            while(true){
            if(mat.empty()){
                try {
                    Thread.sleep(200);
                    matToBufferedImageConverter.setMatrix(mat,".jpg");
                    BufferedImage bufImg = matToBufferedImageConverter.getBufferedImage();
                    facePanel.setFace(bufImg);
                    facePanel.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            }

        }


    }


