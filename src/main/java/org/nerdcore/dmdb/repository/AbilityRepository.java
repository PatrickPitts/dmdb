package org.nerdcore.dmdb.repository;

import org.nerdcore.dmdb.entity.GameEntities.CreatureAbility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository(value="abilityRepository")
@Transactional
public interface AbilityRepository extends JpaRepository<CreatureAbility, Long> {
}
