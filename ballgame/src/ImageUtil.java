import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 读取图片的工具类
 */

public class ImageUtil {
    /**
     * 读取图片的方法
     * @param path
     * @return
     */
    public static BufferedImage getImg(String path){
        //加载图片
        try {
            BufferedImage img = ImageIO.read(ImageUtil.class.getResource(path));
            //如果找到了，返回图片
            return img;
            //如果找不到就捕获找不到的原因
        } catch (IOException e) {
            //下面会输出找不到的原因
            e.printStackTrace();
        }
        return null;
    }
}
