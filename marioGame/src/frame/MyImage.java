package frame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MyImage {
    public static BufferedImage getImage(String path){
        BufferedImage image = null;
        try {
            image = ImageIO.read(MyImage.class.getResource(path));
        } catch (IOException e) {
            System.out.println(path);
            e.printStackTrace();
        }
        return image;
    }
}
