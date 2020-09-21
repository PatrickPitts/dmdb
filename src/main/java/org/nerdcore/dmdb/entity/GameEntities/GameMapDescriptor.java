package org.nerdcore.dmdb.entity.GameEntities;

public class GameMapDescriptor implements Comparable<GameMapDescriptor> {

    private String locationIdentifier;
    private String description;

    public GameMapDescriptor() {
    }

    public GameMapDescriptor(String locationIdentifier, String description) {
        this.locationIdentifier = locationIdentifier;
        this.description = description;
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

    @Override
    public int compareTo(GameMapDescriptor that){
        return this.getLocationIdentifier().compareTo(that.getLocationIdentifier());
    }

    @Override
    public String toString(){
        return this.getDescription();
    }
}
