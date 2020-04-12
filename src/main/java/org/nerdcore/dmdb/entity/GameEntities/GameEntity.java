package org.nerdcore.dmdb.entity.GameEntities;

import javax.persistence.*;
import javax.swing.text.AbstractDocument;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Game_Entity_Type")
public abstract class GameEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long gameEntityId;
    private String sourceBook;
    private int sourceBookPage = -1;

    public GameEntity() {
    }

    public Long getGameEntityId() {
        return gameEntityId;
    }

    public void setGameEntityId(Long gameEntityId) {
        this.gameEntityId = gameEntityId;
    }

    public String getSourceBook() {
        return sourceBook;
    }

    public void setSourceBook(String sourceBook) {
        this.sourceBook = sourceBook;
    }

    public int getSourceBookPage() {
        return sourceBookPage;
    }

    public void setSourceBookPage(int sourceBookPage) {
        this.sourceBookPage = sourceBookPage;
    }
}
