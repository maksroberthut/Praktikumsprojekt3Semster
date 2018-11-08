import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class OpenJPanel extends JPanel {

    VideoCapture camera;
    Mat frame = new Mat();

    OpenJPanel(){
    camera = new VideoCapture();
    camera.open(0);
    }

    public VideoCapture stream(VideoCapture stream, JPanel panel){

        if(!stream.isOpened()){
            System.out.println("Stream Opening Error");
        }else{
            while(stream.read(frame)){

            }
        }


        return camera;
    }

}
