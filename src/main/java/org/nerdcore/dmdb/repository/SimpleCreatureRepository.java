package org.nerdcore.dmdb.repository;

import org.nerdcore.dmdb.entity.GameEntities.SimpleCreature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.transaction.Transactional;
import java.util.List;

@Repository(value="simpleCreatureRepository")
@Transactional
public interface SimpleCreatureRepository extends JpaRepository<SimpleCreature, Long> {

    List<SimpleCreature> findAllBySimpleCreatureName(String creatureName);


}
