package org.nerdcore.dmdb.entity.GameEntities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameMapWithDescriptors {

    private List<GameMapDescriptor> descriptors = new ArrayList<>();
    private String mapName;
    private BufferedImage mapImage;

    public void addDescriptor(GameMapDescriptor descriptor){
        this.descriptors.add(descriptor);
    }

    public GameMapWithDescriptors(String mapIdentifier){
       this.mapName = mapIdentifier;
       //TODO Offload fetching image
        try {
            this.mapImage = ImageIO.read(new File("src/main/resources/images/toh_5e_cropped.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//