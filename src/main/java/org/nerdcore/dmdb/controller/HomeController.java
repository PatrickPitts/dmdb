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

    @Autowired
    GameMapRepository gmr;

    @RequestMapping(value = "/creature/{creatureName}" )
    public ResponseEntity<SimpleCreature> getTest(@PathVariable(value = "creatureName") String creatureName){



        SimpleCreature request = scs.findSimpleCreatureByName(creatureName);

        return ResponseEntity.ok(request);

    }

    @RequestMapping(value="/gamemap")
    public ResponseEntity<GameMapWithDescriptors> getGameMap(){
        GameMapWithDescriptors g = new GameMapWithDescriptors();
        g.setMapName("Tomb of Horrors");
        return ResponseEntity.ok(g);
    }
    @GetMapping(value = "/sources")
    public ResponseEntity<List<Sourcebook>> getEstablishedSourcebooks(){

        return ResponseEntity.ok(sourcebookRepository.findAll());
    }

    @RequestMapping(value="/init")
    public void initGameMaps(){
        GameMapWithDescriptors g = new GameMapWithDescriptors();
        List<GameMapDescriptor> descriptors = new ArrayList<>();
        descriptors.add(new GameMapDescriptor("1", "First Room", g));
        descriptors.add(new GameMapDescriptor("2", "Second Room", g));
        descriptors.add(new GameMapDescriptor("3", "Third Room", g));
        descriptors.add(new GameMapDescriptor("3A", "Subroom A", g));
        descriptors.add(new GameMapDescriptor("3B", "Subroom B", g));

        g.setDescriptors(descriptors);
        g.setMapName("toh_5e_cropped.jpg");

        gmr.save(g);

//        GameMapWithDescriptors g = gmr.findDistinctByMapName("toh_5e_cropped.jpg");
//
//        System.out.println(g.getDescriptors());
    }
}
