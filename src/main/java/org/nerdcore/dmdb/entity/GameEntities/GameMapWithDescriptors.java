package org.nerdcore.dmdb.entity.GameEntities;

import org.nerdcore.dmdb.repository.GameMapRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "gameMap")
public class GameMapWithDescriptors {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameMapID;

    //Intended to be the file name for the image to be stored
    private String mapName;

    //Intended to be the displayed name for the image in the dmdatatolls ui
    private String mapTitle;

    @OneToMany(mappedBy = "gameMap", cascade = CascadeType.ALL)
    private List<GameMapDescriptor> descriptors;

    public GameMapWithDescriptors(){}

    public GameMapWithDescriptors(String mapName, List<GameMapDescriptor> descriptors) {
        this.mapName = mapName;
        this.descriptors = descriptors;
    }

    public Long getGameMapID() {
        return gameMapID;
    }

    public void setGameMapID(Long gameMapID) {
        this.gameMapID = gameMapID;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public List<GameMapDescriptor> getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(List<GameMapDescriptor> descriptors) {
        if(this.descriptors != null){
            for(GameMapDescriptor g : this.descriptors){
                removeGameMapDescriptor(g);
            }
        } else {
            this.descriptors = new ArrayList<>();
        }

        for(GameMapDescriptor g : descriptors){
            addGameMapDescriptor(g);
        }
    }

    public String getMapTitle() {
        return mapTitle;
    }

    public void setMapTitle(String mapTitle) {
        this.mapTitle = mapTitle;
    }

    public void addGameMapDescriptor(GameMapDescriptor g){
        g.setGameMap(this);
        if(this.getDescriptors() == null) descriptors=new ArrayList<>();
        this.descriptors.add(g);
    }

    public void removeGameMapDescriptor(GameMapDescriptor g){
        g.setGameMap(null);
        this.descriptors.remove(g);
    }



    @Override
    public int hashCode(){
        return this.mapName.length();
    }
}
