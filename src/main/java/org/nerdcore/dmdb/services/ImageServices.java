package org.nerdcore.dmdb.services;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageServices {

    public static byte[] getImageByteArrayByMapID(String mapID) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("src/main/resources/images/toh_5e_cropped.jpg"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", bos);
        return bos.toByteArray();
    }
}
