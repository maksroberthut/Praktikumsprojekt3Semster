import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MatToBufferedImage {
    Mat matrix;
    MatOfByte matrixByte;
    String fileID;

    public MatToBufferedImage(){

    }
    public MatToBufferedImage(Mat aMatrix,String afileID){
        matrix = aMatrix;
        fileID = afileID;
    }

    public void setMatrix(Mat aMatrix, String afileID){
        matrix = aMatrix;
        fileID = afileID;
        matrixByte = new MatOfByte();

    }
    public BufferedImage getBufferedImage(){
        Imgcodecs.imencode(".jpg",matrix,matrixByte);
        byte[] byteArray = matrixByte.toArray();
        BufferedImage bufImg = null;

        try{
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImg = ImageIO.read(in);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bufImg;
    }
}
