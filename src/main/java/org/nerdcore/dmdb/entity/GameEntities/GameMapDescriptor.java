package org.nerdcore.dmdb.entity.GameEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="gameMapDescriptor")
public class GameMapDescriptor implements Comparable<GameMapDescriptor> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameMapDescriptorID;

    private String locationIdentifier;
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="gameMap_descriptor", nullable = false)
    private GameMapWithDescriptors gameMap;

    public GameMapDescriptor() {}

    public GameMapDescriptor(String locationIdentifier, String description, GameMapWithDescriptors gameMap) {
        this.locationIdentifier = locationIdentifier;
        this.description = description;
        this.gameMap = gameMap;
    }

    public Long getGameMapDescriptorID() {
        return gameMapDescriptorID;
    }

    public void setGameMapDescriptorID(Long gameMapDescriptorID) {
        this.gameMapDescriptorID = gameMapDescriptorID;
    }

    public String getLocationIdentifier() {
        return locationIdentifier;
    }

    public void setLocationIdentifier(String locationIdentifier) {
        this.locationIdentifier = locationIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GameMapWithDescriptors getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMapWithDescriptors gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public int compareTo(GameMapDescriptor that){
        return this.getLocationIdentifier().compareTo(that.getLocationIdentifier());
    }

    @Override
    public String toString(){
        return this.getDescription();
    }
}
