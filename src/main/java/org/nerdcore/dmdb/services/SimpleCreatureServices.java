package org.nerdcore.dmdb.services;

import org.nerdcore.dmdb.entity.GameEntities.SimpleCreature;
import org.nerdcore.dmdb.repository.SimpleCreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleCreatureServices {

    @Autowired
    SimpleCreatureRepository simpleCreatureRepository;

    public SimpleCreature findSimpleCreatureByName(String name){
        return simpleCreatureRepository.findAllBySimpleCreatureName(name).get(0);
    }

    public SimpleCreature getGoblin(){
        return simpleCreatureRepository.findAllBySimpleCreatureName("Goblin").get(0);
    }

    public void getAllSimpleCreatures(){
        List<SimpleCreature> creatureList=  simpleCreatureRepository.findAll();
        for(SimpleCreature s : creatureList){
            System.out.println(s.getSimpleCreatureName());
        }
    }
}
