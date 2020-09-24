package org.nerdcore.dmdb.repository;

import org.nerdcore.dmdb.entity.GameEntities.GameMapWithDescriptors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameMapRepository extends CrudRepository<GameMapWithDescriptors, Long> {

    GameMapWithDescriptors findDistinctByMapName(String mapName);
}
