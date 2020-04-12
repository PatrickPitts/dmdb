package org.nerdcore.dmdb.repository;

import org.nerdcore.dmdb.entity.GameEntities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository(value="itemRepository")
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {
}
