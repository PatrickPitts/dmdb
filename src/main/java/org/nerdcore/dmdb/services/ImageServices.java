package org.nerdcore.dmdb.services;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Service
public class ImageServices {

    public static byte[] getImageByteArrayByMapID(String mapID) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("src/main/resources/images/"+mapID));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", bos);
        return bos.toByteArray();
    }
}
