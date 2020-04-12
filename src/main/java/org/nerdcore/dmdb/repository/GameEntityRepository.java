package org.nerdcore.dmdb.repository;

import org.nerdcore.dmdb.entity.GameEntities.Creature;
import org.nerdcore.dmdb.entity.GameEntities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository(value="gameEntityRepository")
@Transactional
public interface GameEntityRepository extends JpaRepository<GameEntity, Long> {

    @Query("SELECT e from Creature e")
    List<Creature> findAllCreatures();
}
