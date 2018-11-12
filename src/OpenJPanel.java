import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class OpenJPanel extends JPanel {

    VideoCapture camera;
    Mat frame = new Mat();

    OpenJPanel(){

    camera = new VideoCapture(0);
    camera.open(0);
    JFrame screen = new JFrame();
    screen.setSize(200,200);
    stream(camera,screen);


    }

    public VideoCapture stream(VideoCapture stream, JFrame screen){

        if(!stream.isOpened()){
            System.out.println("Stream Opening Error");
        }else{
            while(stream.read(frame)){
                return camera;

            }
        }


        return camera;
    }

}
