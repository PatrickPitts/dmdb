package org.nerdcore.dmdb.repository;

import org.nerdcore.dmdb.entity.GameEntities.Sourcebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository(value="sourcebookRepository")
@Transactional
public interface SourcebookRepository extends JpaRepository<Sourcebook, Long> {
}
