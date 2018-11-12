import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;

public class Main extends OpenJPanel{

    public static void main (String[] args){
        cameraStream();

    }
    public static VideoCapture cameraStream(){
        Mat mat = new Mat(1);
        JFrame screen = new JFrame();
        screen.setSize(200,200);
        JPanel facePanel = new JPanel();
        screen.setContentPane(facePanel);
        VideoCapture camera = new VideoCapture(3);
        camera.open(0);
        screen.setSize(200,200);
        if(!camera.isOpened()){
            System.out.println("Stream Opening Error");
        }else{
            while(camera.read(mat)){
                facePanel.repaint();

            }
        }
        return camera;

        if(camera.isOpened()){

        }

    }
}
