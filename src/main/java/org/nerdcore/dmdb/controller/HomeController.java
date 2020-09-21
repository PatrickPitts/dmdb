package org.nerdcore.dmdb.controller;

import org.nerdcore.dmdb.entity.GameEntities.*;
import org.nerdcore.dmdb.repository.*;
import org.nerdcore.dmdb.services.SimpleCreatureServices;
import org.nerdcore.dmdb.services.StringManipulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AbilityRepository abilityRepository;

    @Autowired
    GameEntityRepository gameEntityRepository;

    @Autowired
    SourcebookRepository sourcebookRepository;

    @Autowired
    SimpleCreatureRepository simpleCreatureRepository;

    @Autowired
    SimpleCreatureServices scs;

    @RequestMapping(value = "/creature/{creatureName}" )
    public ResponseEntity<SimpleCreature> getTest(@PathVariable(value = "creatureName") String creatureName){



        SimpleCreature request = scs.findSimpleCreatureByName(creatureName);

        return ResponseEntity.ok(request);

    }

    @RequestMapping(value="/gamemap")
    public ResponseEntity<GameMapWithDescriptors> getGameMap(){
        GameMapWithDescriptors g = new GameMapWithDescriptors("Tomb of Horrors");
        return ResponseEntity.ok(g);
    }
    @GetMapping(value = "/sources")
    public ResponseEntity<List<Sourcebook>> getEstablishedSourcebooks(){

        return ResponseEntity.ok(sourcebookRepository.findAll());
    }
}
