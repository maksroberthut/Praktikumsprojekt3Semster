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
   private BufferedImage bufImg ;

    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main (String[] args){
        try {
            cameraStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static VideoCapture cameraStream() throws IOException {
        Mat mat = new Mat();

        JFrame screen = new JFrame();
        screen.setVisible(true);
        screen.setSize(800,800);
        screen.setVisible(true);



        JPanel facePanel = new JPanel();
        screen.setContentPane(facePanel);
        facePanel.setVisible(true);

        VideoCapture camera = new VideoCapture();
        camera.open(0);
        screen.setSize(800,800);

        if(!camera.isOpened()){
            System.out.println("Stream Opening Error");
           // JOptionPane.showMessageDialog(null,"Please check you'r Device", "Camera",JOptionPane.INFORMATION_MESSAGE);
        }else{
            while(true){
            if(mat.empty()){
                try {
                    Thread.sleep(200);

                    facePanel.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            }

        }
        return camera;

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(this.bufImg==null){
            return;
        }
        g.drawImage(this.bufImg,10,10,this.bufImg.getWidth(null),this.bufImg.getHeight(null),null);
    }
    public void setFace (BufferedImage img){
        bufImg = img;
    }

    public BufferedImage getBufImg(){
        return bufImg;
    }
}
